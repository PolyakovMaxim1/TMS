package netCracker.tms.controller;

import netCracker.tms.models.Gender;
import netCracker.tms.models.Role;
import netCracker.tms.models.User;
import netCracker.tms.services.Implements.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    public ModelAndView registration(@RequestParam String firstName,
                                     @RequestParam String secondName,
                                     @RequestParam String login,
                                     @RequestParam String password,
                                     @RequestParam String gender,
                                     @RequestParam String email) {
        User user = new User(firstName, secondName, login, passwordEncoder.encode(password), Gender.valueOf(gender) , email);
        user.setRoles(Collections.singleton(Role.USER));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        userService.insertUser(user);
        return modelAndView;
    }
}
