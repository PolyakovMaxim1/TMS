package netCracker.tms.controller;

import netCracker.tms.models.Enums.Role;
import netCracker.tms.models.User;
import netCracker.tms.services.Implements.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping(value = "/registration")
    public ModelAndView registrationPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registration(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singleton(Role.USER));

        ModelAndView modelAndView = new ModelAndView();
        if(userService.isExistEmailOrLogin(user.getLogin(), user.getEmail())){
            String message = "User exists!";
            modelAndView.addObject("message", message);
            modelAndView.setViewName("/registration");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/login");
        userService.insertUser(user);
        return modelAndView;
    }
}
