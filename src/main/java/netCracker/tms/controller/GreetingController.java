package netCracker.tms.controller;

import netCracker.tms.models.*;
import netCracker.tms.models.Enums.Gender;
import netCracker.tms.models.Enums.Role;
import netCracker.tms.models.Enums.TicketStatus;
import netCracker.tms.services.withoutRep.serviceImplementswithoutRep.UserService;
import netCracker.tms.services.withoutRep.serviceInterfacewithoutRep.UserServiceInterface;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class GreetingController {

    private UserServiceInterface userService = new UserService();
//    @Autowired
//    UserService userService;


    @GetMapping (value = "/")
    public ModelAndView mainPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("greetings");
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
    public ModelAndView addUser(@RequestParam String firstName,
                                @RequestParam String secondName,
                                @RequestParam String login,
                                @RequestParam String password,
                                @RequestParam int gender,
                                @RequestParam String email,
                                @RequestParam int countMakeBug) {
        Set<Role> roles = new HashSet<>();
        roles.add(Role.USER);
        User user = new User(firstName, secondName, login, password, Gender.values()[gender], email, countMakeBug);
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
