package by.bsu.fpmi.kolyadkodarya.controllers;

import by.bsu.fpmi.kolyadkodarya.model.Status;
import by.bsu.fpmi.kolyadkodarya.model.User;
import by.bsu.fpmi.kolyadkodarya.services.StatusService;
import by.bsu.fpmi.kolyadkodarya.services.UserService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Даша on 26.11.2015.
 */
@Controller
public class LoginController
{
    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authManager;

    @Autowired
    private UserService userService;

    @Autowired
    private StatusService statusService;

    @RequestMapping(value = "/tryLogin", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout,
                              HttpServletRequest request) {

        ModelAndView model = new ModelAndView("../WEB-INF/pages/mainPage");

        if (error != null)
        {
            model.addObject("error", "Неверный логин и/или пароль!");
        }

        if (logout != null)
        {
            model.addObject("msg", "Вы успешно вышли из системы.");
        }
        return model;
    }

    @RequestMapping(value = "/trySignUp", method = RequestMethod.GET)
    public ModelAndView registerUser(@ModelAttribute("user") User accountDto, BindingResult result,  Errors errors, HttpServletRequest request){
        User registered = new User();
        accountDto.setStatus(statusService.getDefaultStatus());
        registered.setStatus(accountDto.getStatus());

        if (!result.hasErrors()) {
            registered = createUserAccount(accountDto, result);
        }
        if (registered == null) {
            result.rejectValue("username", "message.regError", "Неверный логин и/или пароль!!");
        }
        if (result.hasErrors()) {
            return new ModelAndView("../WEB-INF/pages/signUp", "user", accountDto);
        }
        else {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(registered.getUsername(), accountDto.getPassword());

            token.setDetails(new WebAuthenticationDetails(request));
            Authentication authentication = authManager.authenticate(token);

            SecurityContextHolder.getContext().setAuthentication(authentication);

            //this step is important, otherwise the new login is not in session which is required by Spring Security
            request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
            request.getSession().setAttribute("user", registered);
            request.getSession().setAttribute("username", registered.getUsername());
            request.getSession().setAttribute("authorities", authentication.getAuthorities());
            return new ModelAndView("../WEB-INF/pages/mainPage");
        }
    }

    @RequestMapping(value = "/mainPage", method = RequestMethod.GET)
    public ModelAndView getStart() {
        return new ModelAndView("../WEB-INF/pages/mainPage");
    }

    @RequestMapping(value = "/programmingtasks", method = RequestMethod.GET)
    public ModelAndView getIndex(@RequestParam(value = "error", required = false) String error,
                                 @RequestParam(value = "logout", required = false) String logout,
                                 HttpServletRequest request) {
        ModelAndView model = null;
        if (error != null) {
            model = new ModelAndView("../WEB-INF/pages/login");
            model.addObject("error", "Неверный логин и/или пароль!");
        }

        if (logout != null) {
            model = new ModelAndView("../index");
            model.addObject("msg", "Вы успешно вышли из системы.");
        }
        return model;
    }

    private User createUserAccount(User accountDto, BindingResult result) {
        User registered = null;
        try {
            registered = userService.registerNewUserAccount(accountDto);
        } catch (NullPointerException e) {
            return null;
        }
        return registered;
    }
}