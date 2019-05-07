package netCracker.tms.utils;

import netCracker.tms.models.*;
import netCracker.tms.models.Object;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Role.class);
                configuration.addAnnotatedClass(UserStatusInfo.class);
                configuration.addAnnotatedClass(UserStatus.class);
                configuration.addAnnotatedClass(Object.class);
                configuration.addAnnotatedClass(Ticket.class);
                configuration.addAnnotatedClass(TicketCategory.class);
                configuration.addAnnotatedClass(TicketPriority.class);
                configuration.addAnnotatedClass(TicketStatus.class);
                configuration.addAnnotatedClass(TicketAnswer.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}
// сервис юзер -
// в ресурсес


// юзер дао стал репозиторием дао слой это репозиторий сервисный слой -
//