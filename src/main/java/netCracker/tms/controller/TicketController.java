package netCracker.tms.controller;


import netCracker.tms.models.Ticket;
import netCracker.tms.services.Implements.TicketService;
import netCracker.tms.services.withoutRep.serviceImplementswithoutRep.*;
import netCracker.tms.services.withoutRep.serviceInterfacewithoutRep.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

@Controller
public class TicketController {

    @Autowired
    private TicketService ticketService;

    private UserServiceInterface userService = new UserService();

    @GetMapping (value = "/ticket")
    public ModelAndView allTickets(){
        List<Ticket> tickets = ticketService.findAllTickets();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tickets");
        modelAndView.addObject("ticketList", tickets);
        return modelAndView;
    }



//    @RequestMapping(value = "/addTicket", method = RequestMethod.GET)
//    public ModelAndView addPage() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("editPageTicket");
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/addTicket", method = RequestMethod.POST)
//    public ModelAndView addUser(@RequestParam String name,
//                                @RequestParam String password,
//                                @RequestParam String email,
//                                @RequestParam int countMakeBug,
//                                Map<String, Object> model) {
//        Set<Role> roles = new HashSet<>();
//        roles.add(Role.USER);
//        User user = new User(name, password, email, countMakeBug);
//        user.setRoles(roles);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("redirect:/");
//        userService.saveUser(user);
//        return modelAndView;
//    }

}

