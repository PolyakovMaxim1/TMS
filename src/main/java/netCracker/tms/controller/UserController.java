package netCracker.tms.controller;

import netCracker.tms.models.Enums.Role;
import netCracker.tms.models.Enums.TicketCategory;
import netCracker.tms.models.Enums.TicketPriority;
import netCracker.tms.models.Enums.TicketStatus;
import netCracker.tms.models.Ticket;
import netCracker.tms.models.User;
import netCracker.tms.services.Implements.TicketService;
import netCracker.tms.services.Implements.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    PasswordEncoder passwordEncoder;


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

    @GetMapping (value = "/userList")
    public ModelAndView allUsersPage(@AuthenticationPrincipal User currentUser){
        List<User> users = userService.findAllUsers();
        ModelAndView modelAndView = new ModelAndView();
        boolean isInMemoryUser = userService.isInMemoryUser();
        boolean isAdmin = false;
        if(isInMemoryUser){
            isAdmin = userService.getUserDetails().getAuthorities().stream()
                    .anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"));
            modelAndView.addObject("inMemoryUser", userService.getUserDetails());
        }
        else {
            isAdmin = userService.currentUserHasRole(Role.ADMIN);
            modelAndView.addObject("currentUser", currentUser);
        }
        modelAndView.addObject("isAdmin", isAdmin);
        modelAndView.addObject("isInMemoryUser", isInMemoryUser);
        modelAndView.setViewName("users");
        modelAndView.addObject("userList", users);
        return modelAndView;
    }

    @GetMapping(value = "/userList/deleteUser/{idUser}")
    public ModelAndView deleteUser(@PathVariable("idUser") long idUser){
        User deleteUser = userService.findUserById(idUser);
        userService.deleteUser(deleteUser);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/userList");
        return modelAndView;
    }

    @GetMapping(value = "/userList/addUser")
    public ModelAndView addUser(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPageUser");
        return modelAndView;
    }

    @PostMapping(value = "/userList/addUser")
    public ModelAndView addUser(User user,
                                @RequestParam(required = false) Role role1,
                                @RequestParam(required = false) Role role2){
        ModelAndView modelAndView = new ModelAndView();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if(userService.isExistEmailOrLogin(user.getLogin(), user.getEmail())){
            String message = "User exists!";
            modelAndView.addObject("message", message);
            modelAndView.setViewName("editUserPage");
            return modelAndView;
        }
        Set<Role> roles = new HashSet();
        if(role1 != null){
            roles.add(role1);
        }
        if(role2 != null){
            roles.add(role2);
        }
        user.setRoles(roles);
        userService.insertUser(user);
        modelAndView.setViewName("redirect:/userList");
        return modelAndView;
    }

    @GetMapping(value = "/userList/editUser/{idUser}")
    public ModelAndView editUser(@PathVariable long idUser){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPageUser");
        modelAndView.addObject("user", userService.findUserById(idUser));
        return modelAndView;
    }

    @PostMapping(value = "/userList/editUser/{idUser}")
    public ModelAndView editUser(User user,
                                @PathVariable long idUser,
                                @RequestParam(required = false) Role role1,
                                @RequestParam(required = false) Role role2){
        ModelAndView modelAndView = new ModelAndView();
        Set<Role> roles = new HashSet();
        if(role1 != null){
            roles.add(role1);
        }
        if(role2 != null){
            roles.add(role2);
        }
        user.setRoles(roles);
        User updatableUser = userService.findUserById(idUser);
        if(user.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        } else {
            user.setPassword(updatableUser.getPassword());
        }
        BeanUtils.copyProperties(user, updatableUser, "id","answers", "tickets");
        userService.updateUser(updatableUser);
        modelAndView.setViewName("redirect:/userList");
        return modelAndView;
    }
}
