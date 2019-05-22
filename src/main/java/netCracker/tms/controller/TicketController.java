package netCracker.tms.controller;

import netCracker.tms.models.Enums.Role;
import netCracker.tms.models.Enums.TicketCategory;
import netCracker.tms.models.Enums.TicketPriority;
import netCracker.tms.models.Enums.TicketStatus;
import netCracker.tms.models.Ticket;
import netCracker.tms.models.TicketAnswer;
import netCracker.tms.models.User;
import netCracker.tms.services.Implements.TicketCommentService;
import netCracker.tms.services.Implements.TicketService;
import netCracker.tms.services.Implements.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Controller
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    @Autowired
    private TicketCommentService ticketCommentService;

    @GetMapping(value = "/ticket")
    public ModelAndView allTickets(@AuthenticationPrincipal User user) {
        List<Ticket> tickets = ticketService.findAllTickets();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tickets");
        modelAndView.addObject("ticketList", tickets);
        modelAndView.addObject("isAdmin", userService.currentUserHasRole(Role.ADMIN));

        return modelAndView;

    }

    @GetMapping(value = "/userpage/alltickets/{id}")
    public ModelAndView allUserTickets(@AuthenticationPrincipal User user,
                                       @PathVariable("id") int id) {
        List<Ticket> tickets = ticketService.findAllTickets();
        ModelAndView modelAndView = new ModelAndView();
        String param = "alltickets";
        modelAndView.setViewName("userpage");
        modelAndView.addObject("message", "All tickets");
        modelAndView.addObject("message2", param);
        modelAndView.addObject("ticketList", tickets);
        modelAndView.addObject("isAdmin", userService.currentUserHasRole(Role.ADMIN));
        modelAndView.addObject("currentUser", user);
        return modelAndView;
    }

    @GetMapping(value = "/userpage/raisedBy/{id}")
    public ModelAndView raisedByTickets(@AuthenticationPrincipal User user,
                                    @PathVariable("id") int id) {
//        List<Ticket> tickets = user.getTickets().stream().collect(Collectors.toList());
//        List<Ticket> tickets = ticketService.findAllByRaisedBy(user.getId());
        List<Ticket> tickets = ticketService.findAllByRaisedBy(user);
        ModelAndView modelAndView = new ModelAndView();
        String param = "raisedBy";
        modelAndView.setViewName("userpage");
        modelAndView.addObject("message", "My tickets");
        modelAndView.addObject("message2", param);
        modelAndView.addObject("ticketList", tickets);
        modelAndView.addObject("currentUser", user);
        modelAndView.addObject("isAdmin", userService.currentUserHasRole(Role.ADMIN));
        return modelAndView;
    }

    @GetMapping(value = "/userpage/assignedTo/{id}")
    public ModelAndView AssignedToTickets(@AuthenticationPrincipal User user,
                                    @PathVariable("id") int id) {
//        List<Ticket> tickets = user.getTickets().stream().collect(Collectors.toList());
//        List<Ticket> tickets = ticketService.findAllByRaisedBy(user.getId());
        List<Ticket> tickets = ticketService.findAllByAssignedTo(user);
        ModelAndView modelAndView = new ModelAndView();
        String param = "assignedTo";
        modelAndView.setViewName("userpage");
        modelAndView.addObject("message", "On me tickets");
        modelAndView.addObject("message2", param);
        modelAndView.addObject("ticketList", tickets);
        modelAndView.addObject("currentUser", user);
        modelAndView.addObject("isAdmin", userService.currentUserHasRole(Role.ADMIN));
        return modelAndView;
    }

    @RequestMapping(value = "/userpage/addTicket/{id}", method = RequestMethod.GET)
    public ModelAndView addTicket(@PathVariable("id") int id) {
        User user = userService.findUserById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPageTicket");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/userpage/addTicket/{userId}", method = RequestMethod.POST)
    public ModelAndView addTicket(@AuthenticationPrincipal User currentUser,
                                  @PathVariable("userId") int userId,
                                  Ticket ticket) {
        ticket.setDateDiscovery(new Date(System.currentTimeMillis()));
        ticket.setRaisedBy(currentUser);
        ticketService.insertTicket(ticket);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/userpage/raisedBy/" + userId);
        return modelAndView;
    }

    @GetMapping(value = "/userpage/{param}/deleteTicket/{id}")
    public ModelAndView deleteTicket(@AuthenticationPrincipal User currentUser,
                                     @PathVariable("param") String param,
                                     @PathVariable("id") int id) {
        Ticket ticket = ticketService.findTicketById(id);
        ticketService.deleteTicket(ticket);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/userpage/{param}/{id}");
        return modelAndView;
    }

    @PostMapping(value = "/userpage/filter")
    public ModelAndView filter(@AuthenticationPrincipal User currentUser,
                               Ticket ticket,
                               @RequestParam(required = false) String raisedByFirstName,
                               @RequestParam(required = false) String raisedBySecondName,
                               @RequestParam(required = false) String assignedToFirstName,
                               @RequestParam(required = false) String assignedToSecondName) {

        List<Ticket> tickets = ticketService.filter(ticket,
                raisedByFirstName,
                raisedBySecondName,
                assignedToFirstName,
                assignedToSecondName);
        ModelAndView modelAndView = new ModelAndView();
        String param = "alltickets";
        modelAndView.setViewName("userpage");
        modelAndView.addObject("message", "All tickets");
        modelAndView.addObject("message2", param);
        modelAndView.addObject("ticketList", tickets);
        modelAndView.addObject("currentUser", currentUser);
        modelAndView.addObject("isAdmin", userService.currentUserHasRole(Role.ADMIN));
        return modelAndView;
    }

    @RequestMapping(value = "/userpage/{param}/editTicket/{idTicket}", method = RequestMethod.GET)
    public ModelAndView updateTicket(@PathVariable("idTicket") int idTicket,
                                     @PathVariable("param") String param,
                                     @AuthenticationPrincipal User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPageTicket");
        modelAndView.addObject("ticket", ticketService.findTicketById(idTicket));
        modelAndView.addObject("user", user);
        modelAndView.addObject("messageUpdate", param);
        return modelAndView;
    }

    @RequestMapping(value = "/userpage/{param}/editTicket/{idTicket}", method = RequestMethod.POST)
    public ModelAndView updateTicket(@AuthenticationPrincipal User currentUser,
                                  @PathVariable("idTicket") long idTicket,
                                  @PathVariable("param") String param,
                                  Ticket newTicket) {

        Ticket updatable = ticketService.findTicketById(idTicket);
        newTicket.setAnswers(updatable.getAnswers());
        newTicket.setRaisedBy(currentUser);
        newTicket.setDateDiscovery(updatable.getDateDiscovery());

        ticketService.updateTicket(newTicket);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/userpage/{param}/" + currentUser.getId());
        return modelAndView;
    }

}

