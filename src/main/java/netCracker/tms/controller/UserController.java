package netCracker.tms.controller;

import netCracker.tms.models.Enums.Role;
import netCracker.tms.models.Ticket;
import netCracker.tms.models.User;
import netCracker.tms.services.Implements.TicketService;
import netCracker.tms.services.Implements.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public ModelAndView userPage(@AuthenticationPrincipal User currentUser){
        ModelAndView modelAndView = new ModelAndView();
        List<Ticket> tickets = currentUser.getTickets().stream().collect(Collectors.toList());
        modelAndView.setViewName("userpage");
        modelAndView.addObject("isAdmin", userService.currentUserHasRole(Role.ADMIN));
        modelAndView.addObject("currentUser", currentUser);
        modelAndView.addObject("ticketList", tickets);
        return modelAndView;
    }

    @RequestMapping(value="/addTicket/{id}", method = RequestMethod.GET)
    public ModelAndView addTicket(@PathVariable("id") int id) {
        User user = userService.findUserById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPageTicket");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

}
