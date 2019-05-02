package netCracker.tms.dao.withoutRep.implementsDao;

import netCracker.tms.dao.withoutRep.interfaceDao.RoleDaoInterface;
import netCracker.tms.models.Role;
import org.hibernate.Session;
import org.hibernate.Transaction;
import netCracker.tms.utils.HibernateSessionFactoryUtil;

public class RoleDaoImplements implements RoleDaoInterface {

    public Role findById(long id) {
        return HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .get(Role.class, id);
    }

    public void save(Role role) {
        Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
        Transaction transaction = session.beginTransaction();
        session.save(role);
        transaction.commit();
        session.close();
    }

    public void update(Role role) {
        Session session = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession();
        Transaction transaction = session.beginTransaction();
        session.update(role);
        transaction.commit();
        session.close();
    }

    public void delete(Role role) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(role);
        transaction.commit();
        session.close();
    }

}
