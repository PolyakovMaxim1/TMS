package netCracker.tms.controller;

import netCracker.tms.models.*;
import netCracker.tms.services.withoutRep.serviceImplementswithoutRep.UserService;
import netCracker.tms.services.withoutRep.serviceInterfacewithoutRep.UserServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class GreetingController {

    private UserServiceInterface userService = new UserService();

    @GetMapping (value = "/")
    public ModelAndView allUsers(){
        List<User> users = userService.getAllUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("userList", users);
        return modelAndView;
    }

    @GetMapping (value = "/test")
    public ModelAndView test(){
        List<User> users = userService.getAllUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping (value = "/edit/{id}")
    public ModelAndView editPageUser(@PathVariable("id") long id){
        User user = userService.findUser(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPageUser");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public ModelAndView editUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        userService.updateUser(user);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPageUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPageUser");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addUser(@RequestParam String name,
                                @RequestParam String password,
                                @RequestParam String email,
                                @RequestParam int countMakeBug) {
        Set<Role> roles = new HashSet<>();
        roles.add(Role.USER);
        User user = new User(name, password, email, countMakeBug);
        user.setRoles(roles);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        userService.saveUser(user);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        User user = userService.findUser(id);
        userService.deleteUser(user);
        return modelAndView;
    }

}
