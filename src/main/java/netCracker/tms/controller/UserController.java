package netCracker.tms.controller;

import netCracker.tms.models.User;
import netCracker.tms.services.withoutRep.serviceImplementswithoutRep.UserService;
import netCracker.tms.services.withoutRep.serviceInterfacewithoutRep.UserServiceInterface;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

@Controller
public class UserController {
    UserServiceInterface userService = new UserService();

    @GetMapping (value = "/")
    public ModelAndView allUsers(){
        List<User> users = userService.getAllUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("userList", users);
        return modelAndView;
    }

    @RequestMapping (value = "/edit", method = RequestMethod.GET)
    public ModelAndView editPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }
//    @RequestMapping(method = RequestMethod.GET)
//    public ModelAndView allUsers() {
//
//    }

}
