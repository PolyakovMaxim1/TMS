package netCracker.tms.services.withoutRep.serviceImplementswithoutRep;

import netCracker.tms.dao.withoutRep.implementsDao.UserDaoImplements;
import netCracker.tms.dao.withoutRep.interfaceDao.UserDaoInterface;
import netCracker.tms.models.*;
import netCracker.tms.services.withoutRep.serviceInterfacewithoutRep.UserServiceInterface;

import java.util.List;

public class UserService implements UserServiceInterface {

    private UserDaoInterface usersDao = new UserDaoImplements();

    public UserService() {
    }

    public List<User> getAllUsers(){return usersDao.allUsers();}

    public User findUser(long id) {
        return usersDao.findById(id);
    }

    public void saveUser(User user) {
        usersDao.save(user);
    }

    public void deleteUser(User user) {
        usersDao.delete(user);
    }

    public void updateUser(User user) {
        usersDao.update(user);
    }

}