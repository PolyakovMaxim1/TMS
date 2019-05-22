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
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private TicketService ticketService;

    @GetMapping (value = "/user")
    public ModelAndView userPage(@AuthenticationPrincipal User currentUser) {ModelAndView modelAndView = new ModelAndView();

        boolean isInMemoryUser = userService.isInMemoryUser();
        boolean isAdmin = false;
        List<Ticket> tickets;
        if(isInMemoryUser){
            tickets = ticketService.findAllTickets();
            isAdmin = userService.getUserDetails().getAuthorities().stream()
                    .anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"));
            modelAndView.addObject("message", "All tickets");
            modelAndView.addObject("inMemoryUser", userService.getUserDetails());
        }
        else {
            tickets = ticketService.findAllByRaisedBy(currentUser);
            isAdmin = userService.currentUserHasRole(Role.ADMIN);
            modelAndView.addObject("message", "My tickets");
            modelAndView.addObject("message2", "raisedBy");
            modelAndView.addObject("currentUser", currentUser);
        }
        modelAndView.setViewName("userpage");
        modelAndView.addObject("isAdmin", isAdmin);
        modelAndView.addObject("isInMemoryUser", isInMemoryUser);
        modelAndView.addObject("ticketList", tickets);

        return modelAndView;
    }
}
