package netCracker.tms.dao.withoutRep.implementsDao;

import netCracker.tms.dao.withoutRep.interfaceDao.UserDaoInterface;
import netCracker.tms.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import netCracker.tms.utils.HibernateSessionFactoryUtil;
import java.util.*;

public class UserDaoImplements implements UserDaoInterface {

    public User findById(long id) {
        return HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .get(User.class, id);
    }

    public List<User> allUsers() {
        return HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("from netCracker.tms.models.User")
                .list();
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
