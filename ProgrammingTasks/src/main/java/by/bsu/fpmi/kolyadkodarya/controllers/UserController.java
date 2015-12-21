package by.bsu.fpmi.kolyadkodarya.controllers;

import by.bsu.fpmi.kolyadkodarya.model.User;
import by.bsu.fpmi.kolyadkodarya.services.UserRoleService;
import by.bsu.fpmi.kolyadkodarya.services.UserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Map;

@Controller
public class UserController
{
    @Autowired
    @Qualifier("sessionRegistry")
    private SessionRegistry sessionRegistry;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService roleService;

    @RequestMapping(value = "/saveProfile", method = RequestMethod.POST)
    public ModelAndView saveUser(@Valid @ModelAttribute("user") User user, BindingResult result, Map<String, Object> map)
    {
        if (result.hasErrors())
        {
            map.put("user", user);
            map.put("roleList", roleService.listRoles());

            return new ModelAndView("../WEB-INF/pages/userEditProfile");

        } else {
//            User registered = new User();
//            registered = createUserAccount(user);
//
//            userService.save(registered);
            return new ModelAndView("redirect:/index");
        }
    }

    @RequestMapping("/editUserProfile/${username}")
    public ModelAndView editProfile(@PathVariable("username") String username,
                                Map<String, Object> map)
    {
        return new ModelAndView("../WEB-INF/pages/userEditProfile", "userToEdit", userService.readUserByUsername(username));
    }
}