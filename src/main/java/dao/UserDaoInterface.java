package dao;

import models.Role;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;

public interface UserDaoInterface {

    public User findById(int id);

    public void save(User user);

    public void update(User user);

    public void delete(User user);

}
