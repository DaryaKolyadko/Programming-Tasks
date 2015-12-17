package by.bsu.fpmi.kolyadkodarya.controllers;

import by.bsu.fpmi.kolyadkodarya.model.Category;
import by.bsu.fpmi.kolyadkodarya.services.CategoryService;
import by.bsu.fpmi.kolyadkodarya.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Map;

/**
 * Created by Даша on 07.12.2015.
 */

@Controller
public class CategoryController
{
    @Autowired
    @Qualifier("sessionRegistry")
    private SessionRegistry sessionRegistry;

    //@Autowired
    // @Qualifier("categoryService")
    private CategoryService categoryService;


    @RequestMapping(value = "/addTask", method = RequestMethod.GET)
    public ModelAndView userList(Model model, Principal principal, Category category)
    {
        model.addAttribute("categoryList", categoryService.listCategories());
        return new ModelAndView("../WEB-INF/pages/createTask");
    }

}
