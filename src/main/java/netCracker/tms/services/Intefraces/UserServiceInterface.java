package netCracker.tms.services.Intefraces;

import netCracker.tms.models.Enums.Role;
import netCracker.tms.models.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserServiceInterface {

    User findUserById(long id);

    User findUserByLogin(String name);

    User findUserByEmail(String email);

    void insertUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

    List<User> findAllUsers();

    boolean currentUserHasRole(Role role);

    public UserDetails getUserDetails();

    public boolean isExistEmailOrLogin(String login, String email);

    public List<User> findByFirstNameSecondName(String firstName, String secondName);

    public boolean isInMemoryUser();
}
