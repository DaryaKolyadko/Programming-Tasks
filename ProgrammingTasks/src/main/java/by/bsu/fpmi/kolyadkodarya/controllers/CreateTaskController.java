package by.bsu.fpmi.kolyadkodarya.controllers;

import by.bsu.fpmi.kolyadkodarya.services.CategoryService;
import by.bsu.fpmi.kolyadkodarya.services.ComplexityLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Даша on 07.12.2015.
 */

@Controller
public class CreateTaskController
{
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ComplexityLevelService complexityLevelService;

    @RequestMapping(value = "/createTask", method = RequestMethod.GET)
    public ModelAndView createTask(Model model)
    {
        model.addAttribute("categoryList", categoryService.listCategories());
        model.addAttribute("complexityLevelList", complexityLevelService.listComplexityLevels());
        return new ModelAndView("../WEB-INF/pages/createTask");
    }
}