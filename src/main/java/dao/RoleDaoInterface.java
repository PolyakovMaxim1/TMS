package dao;

import models.Role;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;

public interface RoleDaoInterface {

    public Role findById(int id);

    public void save(Role role);

    public void update(Role role);

    public void delete(Role role);

}
