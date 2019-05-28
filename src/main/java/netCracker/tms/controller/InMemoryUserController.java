package netCracker.tms.controller;

import netCracker.tms.models.Ticket;
import netCracker.tms.services.Implements.TicketService;
import netCracker.tms.services.Implements.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

@Controller
public class InMemoryUserController {

    @Autowired
    TicketService ticketService;

    @Autowired
    UserService userService;

    @GetMapping(value = "/userpage/deleteTicket/{id}")
    public ModelAndView deleteTicket(@PathVariable("id") int id) {
        Ticket ticket = ticketService.findTicketById(id);
        ticketService.deleteTicket(ticket);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/user");
        return modelAndView;
    }

    @GetMapping(value = "/userpage/addTicket")
    public ModelAndView addTicketPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPageTicket");
        modelAndView.addObject("listUsers", userService.findAllUsers());
        modelAndView.addObject("isAdmin", userService.getUserDetails().getAuthorities().stream()
                .anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN")));
        modelAndView.addObject("isInMemoryUser", userService.isInMemoryUser());
        return modelAndView;
    }

    @PostMapping(value = "/userpage/addTicket")
    public ModelAndView addTicket(Ticket ticket) {
        ticket.setDateDiscovery(new Date(System.currentTimeMillis()));
        ticketService.insertTicket(ticket);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/user");
        return modelAndView;
    }

    @GetMapping(value = "/userpage/editTicket/{idTicket}")
    public ModelAndView editTicketPage(@PathVariable("idTicket") int idTicket) {
        Ticket ticket = ticketService.findTicketById(idTicket);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPageTicket");
        modelAndView.addObject("ticket", ticket);
        modelAndView.addObject("isAdmin", userService.getUserDetails().getAuthorities().stream()
                .anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN")));
        modelAndView.addObject("listUsers", userService.findAllUsers());
        modelAndView.addObject("isInMemoryUser", userService.isInMemoryUser());
        return modelAndView;
    }

    @PostMapping(value = "/userpage/editTicket/{idTicket}")
    public ModelAndView editTicket(Ticket newTicket,
                                   @PathVariable("idTicket") int idTicket) {
//        ticketService.deleteTicket(ticketService.findTicketById(idTicket));
        Ticket updatable = ticketService.findTicketById(idTicket);
        newTicket.setAnswers(updatable.getAnswers());
        newTicket.setDateDiscovery(updatable.getDateDiscovery());
        ticketService.updateTicket(newTicket);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/user");
        return modelAndView;
    }
}
