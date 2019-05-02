package netCracker.tms.services.withoutRep.serviceInterfacewithoutRep;

import netCracker.tms.models.User;

import java.util.List;

public interface UserServiceInterface {

    public List<User> getAllUsers();

    public User findUser(long id);

    public void saveUser(User user);

    public void deleteUser(User user);

    public void updateUser(User user);
}
