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
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    @GetMapping (value = "/ticket")
    public ModelAndView allTickets(@AuthenticationPrincipal User user){
        List<Ticket> tickets = ticketService.findAllTickets();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tickets");
        modelAndView.addObject("ticketList", tickets);
        modelAndView.addObject("isAdmin", userService.currentUserHasRole(Role.ADMIN));
        return modelAndView;
    }

    @GetMapping (value = "/userpage/alltickets/{id}")
    public ModelAndView allUserTickets(@AuthenticationPrincipal User user,
                                       @PathVariable("id") int id){
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

    @GetMapping (value = "/userpage/mytickets/{id}")
    public ModelAndView UserTickets(@AuthenticationPrincipal User user,
                                    @PathVariable("id") int id){
//        List<Ticket> tickets = user.getTickets().stream().collect(Collectors.toList());
//        List<Ticket> tickets = ticketService.findAllByRaisedBy(user.getId());
        List<Ticket> tickets = ticketService.findAllByRaisedBy(user);
        ModelAndView modelAndView = new ModelAndView();
        String param = "mytickets";
        modelAndView.setViewName("userpage");
        modelAndView.addObject("message", "My tickets");
        modelAndView.addObject("message2", param);
        modelAndView.addObject("ticketList", tickets);
        modelAndView.addObject("currentUser", user);
        modelAndView.addObject("isAdmin", userService.currentUserHasRole(Role.ADMIN));
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

    @RequestMapping(value = "/addTicket/{userId}", method = RequestMethod.POST)
    public ModelAndView addTicket(@AuthenticationPrincipal User currentUser,
                                  @PathVariable("userId") int userId,
                                  @RequestParam String description,
                                  @RequestParam String descriptionDetectionProblem,
                                  @RequestParam String productVersionDiscovery,
                                  @RequestParam String productVersionFixed,
                                  @RequestParam int priorityId,
                                  @RequestParam int statusId,
                                  @RequestParam int categoryId,
                                  @RequestParam int assignedToId) {
        Ticket ticket = new Ticket();
        ticket.setDescription(description);
        ticket.setRaisedBy(userService.findUserById(userId));
        ticket.setDetectionProblemDescription(descriptionDetectionProblem);
        ticket.setPriority(TicketPriority.values()[priorityId]);
        ticket.setStatus(TicketStatus.values()[statusId]);
        ticket.setCategory(TicketCategory.values()[categoryId]);
        ticket.setAssignedTo(userService.findUserById(assignedToId));

        ticketService.insertTicket(ticket);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/userpage/mytickets/" + userId);

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

    @GetMapping(value = "/deleteTicket/{id}")
    public ModelAndView deleteTicket(@PathVariable("id") int id) {
        Ticket ticket = ticketService.findTicketById(id);
        ticketService.deleteTicket(ticket);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/ticket");
        return modelAndView;
    }

//////////////////
//    @PostMapping (value = "/userpage/filter")
//    public ModelAndView filter(@AuthenticationPrincipal User currentUser,
//                               @RequestParam(required = false) String description,
//                               @RequestParam(required = false) String descriptionDetectionProblem,
//                               @RequestParam(required = false) String productVersionDiscovery,
//                               @RequestParam(required = false) String productVersionFixed,
//
//                               @RequestParam(required = false) String priorityId,
//                               @RequestParam(required = false) String statusId,
//                               @RequestParam(required = false) String categoryId,
//                               @RequestParam(required = false) String assignedToId,
//                               @RequestParam(required = false) String raisedById) {
//
//        Ticket ticket = new Ticket();
//
////        ticket.setDescription(description);
////        ticket.setDetectionProblemDescription(descriptionDetectionProblem);
////
////        ticket.setDiscoveryProductVersion(productVersionDiscovery);
////        ticket.setFixedProductVersion(productVersionFixed);
////
////        ticket.setPriority(TicketPriority.values()[priorityId]);
////        ticket.setStatus(TicketStatus.values()[statusId]);
////        ticket.setCategory(TicketCategory.values()[categoryId]);
////
////        ticket.setAssignedTo(userService.findUserById(assignedToId));
//
//        List<Ticket> tickets = ticketService.filter(ticket, null);
//        ModelAndView modelAndView = new ModelAndView();
//        String param = "mytickets";
//        modelAndView.setViewName("userpage");
//        modelAndView.addObject("message", "My tickets");
//        modelAndView.addObject("message2", param);
////        modelAndView.addObject("ticketList", tickets);
//        modelAndView.addObject("currentUser", currentUser);
//        modelAndView.addObject("isAdmin", userService.currentUserHasRole(Role.ADMIN));
//        return modelAndView;
//    }





    @PostMapping (value = "/userpage/filter")
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

}

