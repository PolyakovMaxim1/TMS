package netCracker.tms.services.Implements;

import netCracker.tms.models.Enums.Role;
import netCracker.tms.models.User;
import netCracker.tms.repositories.UserRep;
import netCracker.tms.services.Intefraces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements UserServiceInterface, UserDetailsService {
    @Autowired
    UserRep userRep;

    @Override
    public User findUserById(long id) {
        return userRep.findById(id).get();
    }

    @Override
    public void insertUser(User user) {
        userRep.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRep.delete(user);
    }

    @Override
    public void updateUser(User user) {
        userRep.save(user);
    }
    @Override
    public User findUserByLogin(String name) {
        return userRep.findUserByLogin(name);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRep.findUserByEmail(email);
    }

    @Override
    public List<User> findAllUsers() {
        return userRep.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return username.contains("@") ? userRep.findUserByEmail(username) : userRep.findUserByLogin(username);
    }

    @Override
    public final boolean currentUserHasRole(Role role) {
        boolean hasRole = false;
        UserDetails userDetails = getUserDetails();
        if (userDetails != null) {
            for(GrantedAuthority grantedAuthority : userDetails.getAuthorities()){
                hasRole = (grantedAuthority == role);
                if(hasRole)
                    break;
            }
        }
        return hasRole;
    }
    /**
     * Get info about currently logged in user
     * @return UserDetails if found in the context, null otherwise
     */
    @Override
    public UserDetails getUserDetails() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        return userDetails;
    }

    @Override
    public boolean isExistEmailOrLogin(String login, String email){
        User findUserByLogin = findUserByLogin(login);
        User findUserByEmail = findUserByEmail(email);
        if(findUserByEmail != null || findUserByLogin != null)
            return true;
        return false;
    }

    @Override
    public List<User> findByFirstNameSecondName(String firstName, String secondName){
        return userRep.findAllByFirstNameOrSecondName(firstName, secondName);
    }

    @Override
    public boolean isInMemoryUser(){
        UserDetails userDetails = getUserDetails();
        if(userDetails.getUsername().equals("Admin")
                || userDetails.getUsername().equals("User"))
            return true;
        return false;
    }

}
