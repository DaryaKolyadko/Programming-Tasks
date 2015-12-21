package by.bsu.fpmi.kolyadkodarya.controllers;

import by.bsu.fpmi.kolyadkodarya.model.*;
import by.bsu.fpmi.kolyadkodarya.parser.TagsLineParser;
import by.bsu.fpmi.kolyadkodarya.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Map;
import java.util.Set;

/**
 * Created by Даша on 07.12.2015.
 */

@Controller
public class TaskController
{
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @Autowired
    private TagService tagService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private ComplexityLevelService complexityLevelService;

    @RequestMapping(value = "/createTask", method = RequestMethod.GET)
    public ModelAndView createTask(Model model)
    {
        model.addAttribute("newTask", new Task());
        model.addAttribute("categoryList", categoryService.listCategories());
        model.addAttribute("complexityLevelList", complexityLevelService.listComplexityLevels());
        return new ModelAndView("../WEB-INF/pages/createTask");
    }

    @RequestMapping(value = "/successTaskCreating", method = RequestMethod.POST)
    public ModelAndView addTask(HttpServletRequest request, @ModelAttribute("newTask") Task newTask, BindingResult result,
                                Map<String, Object> map, Principal user)
    {
        User currentUser = userService.readUserByUsername(user.getName());
        Category category = categoryService.getByName(request.getParameter("category"));
        ComplexityLevel complexityLevel = complexityLevelService.getByName(request.getParameter("complexityLevel"));
        newTask.setUserCreator(currentUser);
        newTask.setCategory(category);
        newTask.setComplexityLevel(complexityLevel);
        taskService.save(newTask);
        String tagLine = request.getParameter("tagLine");
        String[] tagList = TagsLineParser.parseTagsLine(tagLine);

        for(String tag: tagList)
        {
            Tag t = tagService.getByName(tag);

            if(t == null)
            {
                t = new Tag();
                t.setTagName(tag);
            }

            tagService.addNewTag(t, newTask);
        }

     //   ModelAndView model = new ModelAndView("../WEB-INF/pages/myTasks");
        userService.update(currentUser);
        return new ModelAndView("../WEB-INF/pages/myTasks", "tasks", currentUser.getTasks());// model;
    }

    @RequestMapping(value = "/myTasks", method = RequestMethod.GET)
    public ModelAndView myTasksList(Model model, Principal user)
    {
        User currentUser = userService.readUserByUsername(user.getName());
        model.addAttribute("tasks", currentUser.getTasks());
        return new ModelAndView("../WEB-INF/pages/myTasks");
    }

    @RequestMapping("/deleteTask/{taskId}")
    public ModelAndView deleteUser(@PathVariable("taskId") int taskId) {

        taskService.delete(taskId);
        return new ModelAndView("redirect:/myTasks");
    }
}