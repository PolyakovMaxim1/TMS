package netCracker.tms.services.Implements;

import netCracker.tms.models.User;
import netCracker.tms.repositories.UserRep;
import netCracker.tms.services.Intefraces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {
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
    public List<User> findAllUsers() {
        return userRep.findAll();
    }
}
