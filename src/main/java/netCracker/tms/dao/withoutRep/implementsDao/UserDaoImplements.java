package netCracker.tms.dao.withoutRep.implementsDao;

import netCracker.tms.dao.withoutRep.interfaceDao.UserDaoInterface;
import netCracker.tms.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import netCracker.tms.utils.HibernateSessionFactoryUtil;
import java.util.*;

public class UserDaoImplements implements UserDaoInterface {

    public User findById(long id) {
        Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    public List<User> allUsers() {
        Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
        List<User> listUser = session.createQuery("from netCracker.tms.models.User")
                                    .list();
        session.close();
        return listUser;

    }

    public void save(User user) {
        Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public void update(User user) {
        Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

}
