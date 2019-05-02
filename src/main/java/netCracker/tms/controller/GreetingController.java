package netCracker.tms.controller;

import netCracker.tms.models.Role;
import netCracker.tms.models.User;
import netCracker.tms.services.withoutRep.serviceImplementswithoutRep.*;
import netCracker.tms.services.withoutRep.serviceInterfacewithoutRep.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

@Controller
public class GreetingController {
    private UserServiceInterface userService = new UserService();
    private RoleServiceInterface roleService = new RoleService();

    @GetMapping (value = "/")
    public ModelAndView greeting(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("greetings");
        return modelAndView;
    }

    @GetMapping (value = "/main")
    public ModelAndView allUsers(){
        List<User> users = userService.getAllUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("userList", users);
        return modelAndView;
    }

    @GetMapping (value = "/main/edit/{id}")
    public ModelAndView editPage(@PathVariable("id") long id){
        User user = userService.findUser(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping(value = "/main/edit")
    public ModelAndView editUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        userService.updateUser(user);
        return modelAndView;
    }

    @RequestMapping(value = "/main/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @RequestMapping(value = "/main/add", method = RequestMethod.POST)
    public ModelAndView addUser(@RequestParam String name,
                                @RequestParam String password,
                                @RequestParam String email,
                                @RequestParam int countMakeBug,
                                Map<String, Object> model) {
        Role role = new Role( "new");
        roleService.saveRole(role);
        User user = new User(name, password, email, role, countMakeBug);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        userService.saveUser(user);
        return modelAndView;
    }

    @RequestMapping(value="/main/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteFilm(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        User user = userService.findUser(id);
        userService.deleteUser(user);
        return modelAndView;
    }

}
