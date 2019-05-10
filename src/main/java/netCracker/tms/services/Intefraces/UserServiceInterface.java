package netCracker.tms.services.Intefraces;

import netCracker.tms.models.User;

import java.util.*;

public interface UserServiceInterface {

    User findUserById(long id);

    User findUserByLogin(String name);

    User findUserByEmail(String email);

    void insertUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

    List<User> findAllUsers();

    boolean currentUserHasRole(String role);
}
