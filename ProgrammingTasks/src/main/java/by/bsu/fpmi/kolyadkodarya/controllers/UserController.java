package by.bsu.fpmi.kolyadkodarya.controllers;

import by.bsu.fpmi.kolyadkodarya.model.User;
import by.bsu.fpmi.kolyadkodarya.services.UserRoleService;
import by.bsu.fpmi.kolyadkodarya.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    @Qualifier("sessionRegistry")
    private SessionRegistry sessionRegistry;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService roleService;

    @RequestMapping("/show_users")
    public ModelAndView userList(Map<String, Object> map, Principal principal, User user) {

        map.put("user", new User());
        map.put("userList", userService.listUsers());
        map.put("roleList", roleService.listRoles());

        if(principal != null){
            String name = principal.getName();
            map.put("username", name);
        }


        return new ModelAndView("../WEB-INF/pages/users/show_users");
    }

    @RequestMapping("/add_user")
    public ModelAndView addUser(Map<String, Object> map) {

        map.put("user", new User());
        map.put("roleList", roleService.listRoles());

        return new ModelAndView("../WEB-INF/pages/users/user_form");
    }

    @RequestMapping(value = "/save_user", method = RequestMethod.POST)
    public ModelAndView saveUser(@Valid @ModelAttribute("user") User user, BindingResult result, Map<String, Object> map) {
        if (result.hasErrors()) {

            map.put("user", user);
            map.put("roleList", roleService.listRoles());

            return new ModelAndView("../WEB-INF/pages/users/user_form");

        } else {
            userService.save(user);
            return new ModelAndView("redirect:/show_users");
        }
    }
}
