package by.bsu.fpmi.kolyadkodarya.controllers;

import by.bsu.fpmi.kolyadkodarya.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by Даша on 18.11.2015.
 */
@Controller
public class MenuController
{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/contactUs", method = RequestMethod.GET)
    public ModelAndView contactUs(){
        return new ModelAndView("../WEB-INF/pages/contactUs");
    }

    @RequestMapping(value = "/forum", method = RequestMethod.GET)
    public ModelAndView goToForum(){
        return new ModelAndView("../WEB-INF/pages/forum");
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home(){
        return new ModelAndView("../index");
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public ModelAndView userInfo(Principal user){
        ModelAndView model = new ModelAndView("../WEB-INF/pages/userInfo");
        model.addObject("user", userService.readUserByUsername(user.getName()));
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(){
        return new ModelAndView("../WEB-INF/pages/login");
    }

    @RequestMapping(value = "/sign_up", method = RequestMethod.GET)
    public ModelAndView register(){
        return new ModelAndView("../WEB-INF/pages/signUp");
    }
}