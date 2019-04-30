package services;

import dao.*;
import models.*;

public class UserService {

    private UserDaoImplements usersDao = new UserDaoImplements();

    public UserService() {
    }

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