package netCracker.tms.controller;

import netCracker.tms.models.Enums.Role;
import netCracker.tms.models.Ticket;
import netCracker.tms.models.User;
import netCracker.tms.services.Implements.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping (value = "/user1")
    public ModelAndView userPage(@AuthenticationPrincipal User currentUser){
        ModelAndView modelAndView = new ModelAndView();
        List<Ticket> tickets = currentUser.getTickets();
        modelAndView.setViewName("userPage");
        modelAndView.addObject("ticketList", tickets);
        modelAndView.addObject("isAdmin", userService.currentUserHasRole(Role.ADMIN));
        modelAndView.addObject("currentUser", currentUser);
        return modelAndView;
    }
}
