package netCracker.tms.controller;

import netCracker.tms.models.User;
import netCracker.tms.services.Implements.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/user")
    public ModelAndView userPage(){
        User currentUser = userService.getUserByContext();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userPage");
        modelAndView.addObject("currentUser", currentUser);
        return modelAndView;
    }
}
