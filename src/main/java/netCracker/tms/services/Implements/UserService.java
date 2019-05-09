package netCracker.tms.services.Implements;

import netCracker.tms.models.User;
import netCracker.tms.repositories.UserRep;
import netCracker.tms.services.Intefraces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<User> findAllUsers() {
        return userRep.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User userFindByLogin = userRep.findUserByLogin(login);
        //Остальные поиски
        if(userFindByLogin != null)
            return userFindByLogin;
        //Остальные проверки
        return null;
    }
}
