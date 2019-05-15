package netCracker.tms.controller;

import netCracker.tms.models.Enums.Role;
import netCracker.tms.models.Enums.TicketCategory;
import netCracker.tms.models.Enums.TicketPriority;
import netCracker.tms.models.Enums.TicketStatus;
import netCracker.tms.models.Ticket;
import netCracker.tms.models.User;
import netCracker.tms.services.Implements.TicketService;
import netCracker.tms.services.Implements.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private TicketService ticketService;

    @GetMapping (value = "/user")
    public ModelAndView userPage(@AuthenticationPrincipal User currentUser) {
        ModelAndView modelAndView = new ModelAndView();
        List<Ticket> tickets = ticketService.findAllByRaisedBy(currentUser);
        modelAndView.setViewName("userpage");
        modelAndView.addObject("message", "My tickets");
        modelAndView.addObject("isAdmin", userService.currentUserHasRole(Role.ADMIN));
        modelAndView.addObject("currentUser", currentUser);
        modelAndView.addObject("ticketList", tickets);
        return modelAndView;
    }

}
