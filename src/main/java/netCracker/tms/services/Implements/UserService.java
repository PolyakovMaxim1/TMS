package netCracker.tms.services.Implements;

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
    public final boolean currentUserHasRole(String role) {
        boolean hasRole = false;
        UserDetails userDetails = getUserDetails();
        if (userDetails != null) {
            for(GrantedAuthority grantedAuthority : userDetails.getAuthorities()){
                hasRole = grantedAuthority.getAuthority().equals(role);
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
    public UserDetails getUserDetails() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        return userDetails;
    }
}
