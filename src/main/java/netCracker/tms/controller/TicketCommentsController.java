package netCracker.tms.controller;

import netCracker.tms.services.Implements.TicketCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TicketCommentsController {
    @Autowired
    TicketCommentService ticketCommentService;

    @GetMapping("/ticketPage/{idTicket}/deleteComment/{idComment}")
    public ModelAndView deleteComment(@PathVariable("idTicket") long idTicket,
                                      @PathVariable("idComment") long idComment){
        ticketCommentService.deleteTicketAnswer(ticketCommentService.findTicketAnswerById(idComment));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/ticketPage/{idTicket}");
        return modelAndView;
    }
}
