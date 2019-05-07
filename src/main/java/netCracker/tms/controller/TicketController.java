package netCracker.tms.controller;

import netCracker.tms.models.Ticket;
import netCracker.tms.models.TicketCategory;
import netCracker.tms.models.TicketPriority;
import netCracker.tms.models.TicketStatus;
import netCracker.tms.services.Implements.TicketService;
import netCracker.tms.services.Implements.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    @GetMapping (value = "/ticket")
    public ModelAndView allTickets(){
        List<Ticket> tickets = ticketService.findAllTickets();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tickets");
        modelAndView.addObject("ticketList", tickets);
        return modelAndView;
    }

    @RequestMapping(value = "/addTicket", method = RequestMethod.GET)
    public ModelAndView addPageTicket() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPageTicket");
        return modelAndView;
    }

    @RequestMapping(value = "/addTicket", method = RequestMethod.POST)
    public ModelAndView addTicket(@RequestParam String description,
                                  @RequestParam String descriptionDetectionProblem,
                                  @RequestParam String productVersionDiscovery,
                                  @RequestParam String productVersionFixed,
                                  @RequestParam int priorityId,
                                  @RequestParam int statusId,
                                  @RequestParam int categoryId,
                                  @RequestParam int raisedById,
                                  @RequestParam int assignedToId) {
        Ticket ticket = new Ticket();
        ticket.setDescription(description);
        ticket.setDetectionProblemDescription(descriptionDetectionProblem);
        ticket.setPriority(TicketPriority.values()[priorityId]);
        ticket.setStatus(TicketStatus.values()[statusId]);
        ticket.setCategory(TicketCategory.values()[categoryId]);
        ticket.setRaisedBy(userService.findUserById(raisedById));
        ticket.setAssignedTo(userService.findUserById(assignedToId));

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/ticket");
        ticketService.insertTicket(ticket);
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

}
