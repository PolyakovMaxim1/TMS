package netCracker.tms.controller;

import netCracker.tms.models.Enums.Role;
import netCracker.tms.models.Ticket;
import netCracker.tms.models.TicketAnswer;
import netCracker.tms.models.User;
import netCracker.tms.services.Implements.TicketCommentService;
import netCracker.tms.services.Implements.TicketService;
import netCracker.tms.services.Implements.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;

@Controller
public class TicketPageController {

    @Autowired
    TicketService ticketService;

    @Autowired
    TicketCommentService ticketCommentService;

    @Autowired
    UserService userService;

    @GetMapping(value = "/ticketPage/{idTicket}")
    public ModelAndView ticketPage(@AuthenticationPrincipal User currentUser,
                                   @PathVariable("idTicket") long idTicket
    ) {

        Ticket ticket = ticketService.findTicketById(idTicket);
        List<TicketAnswer> comments = ticketCommentService.findTicketAnswersByTicket(ticket);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ticket");
        modelAndView.addObject("ticket", ticket);
        modelAndView.addObject("comments", comments);
        modelAndView.addObject("currentUser", currentUser);
        modelAndView.addObject("isAdmin", userService.currentUserHasRole(Role.ADMIN));
        return modelAndView;
    }

    @PostMapping(value = "/ticket/{idTicket}/addComment")
    public ModelAndView addComment(@AuthenticationPrincipal User currentUser,
                                   @PathVariable("idTicket") long idTicket,
                                   @RequestParam String message) {

        TicketAnswer ticketAnswer = new TicketAnswer();
        ticketAnswer.setMessage(message);
        ticketAnswer.setUser(currentUser);
        ticketAnswer.setTicket(ticketService.findTicketById(idTicket));
        ticketAnswer.setDateAnswer(new Date(System.currentTimeMillis()));

        ticketCommentService.insertTicketAnswer(ticketAnswer);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/ticketPage/" + idTicket);
        return modelAndView;
    }
}
