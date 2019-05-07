package netCracker.tms.services.Intefraces;

import netCracker.tms.models.User;
import java.util.*;

public interface UserServiceInterface {

    public User findUserById(long id);

    public void insertUser(User user);

    public void deleteUser(User user);

    public void updateUser(User user);

    public List<User> findAllUsers();
}
