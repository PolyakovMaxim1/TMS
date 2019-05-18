package netCracker.tms.services.Implements;

import netCracker.tms.models.Ticket;
import netCracker.tms.models.User;
import netCracker.tms.repositories.TicketRep;
import netCracker.tms.services.Intefraces.TicketServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.Querydsl;
import org.springframework.stereotype.Service;
import sun.tools.tree.BooleanExpression;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class TicketService implements TicketServiceInterface {
    @Autowired
    TicketRep ticketRep;

    @Autowired
    EntityManager entityManager;

    @Autowired
    UserService userService;

    @Override
    public Ticket findTicketById(long id) {
        return ticketRep.findById(id).get();
    }

    @Override
    public void insertTicket(Ticket ticket) {
        ticketRep.save(ticket);
    }

    @Override
    public void deleteTicket(Ticket ticket) {
        ticketRep.delete(ticket);
    }

    @Override
    public void updateTicket(Ticket ticket) {
    }

    @Override
    public List<Ticket> findAllTickets() {
        return ticketRep.findAll();
    }


    @Override
    public List<Ticket> findAllByRaisedBy(User user) {
        return ticketRep.findAllByRaisedBy(user);
    }

    public List<Ticket> findAll(Ticket ticket){
        BooleanExpression predicate;
        return null;
    }

    @Override
    public List<Ticket> filter(Ticket ticket,
                               String raisedByFirstName,
                               String raisedBySecondName,
                               String assignedToFirstName,
                               String assignedToSecondName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ticket> ticketQuery = criteriaBuilder.createQuery(Ticket.class);
        Root<Ticket> ticketRoot = ticketQuery.from(Ticket.class);
        ticketQuery.select(ticketRoot);

        Predicate criteria = criteriaBuilder.conjunction();
        // Ticket
        if(ticket.getCategory() != null){
            Predicate predicate = criteriaBuilder.equal(ticketRoot.get("category"), ticket.getCategory());
            criteria = criteriaBuilder.and(criteria, predicate);
        }

        if(ticket.getPriority() != null){
            Predicate predicate = criteriaBuilder.equal(ticketRoot.get("priority"), ticket.getPriority());
            criteria = criteriaBuilder.and(criteria, predicate);
        }

        if(ticket.getStatus() != null){
            Predicate predicate = criteriaBuilder.equal(ticketRoot.get("status"), ticket.getStatus());
            criteria = criteriaBuilder.and(criteria, predicate);
        }

        if(ticket.getDescription() != null && !ticket.getDescription().equals("")){
            Predicate predicate = criteriaBuilder.like(ticketRoot.get("description"), "%" + ticket.getDescription() + "%");
            criteria = criteriaBuilder.and(criteria, predicate);
        }

        if(ticket.getDetectionProblemDescription() != null && !ticket.getDetectionProblemDescription().equals("")){
            Predicate predicate = criteriaBuilder.like(ticketRoot.get("detectionProblemDescription"), "%" + ticket.getDetectionProblemDescription() + "%");
            criteria = criteriaBuilder.and(criteria, predicate);
        }

        if(ticket.getDiscoveryProductVersion() != null && !ticket.getDiscoveryProductVersion().equals("")){
            Predicate predicate = criteriaBuilder.equal(ticketRoot.get("discoveryProductVersion"), ticket.getDiscoveryProductVersion());
            criteria = criteriaBuilder.and(criteria, predicate);
        }

        if(ticket.getFixedProductVersion() != null && !ticket.getFixedProductVersion().equals("")){
            Predicate predicate = criteriaBuilder.equal(ticketRoot.get("fixedProductVersion"), ticket.getFixedProductVersion());
            criteria = criteriaBuilder.and(criteria, predicate);
        }
        // Author name
        if(raisedByFirstName != null && !raisedByFirstName.equals("")){
            Predicate firstNamePredicate = criteriaBuilder.equal(ticketRoot.get("raisedBy").get("firstName"), raisedByFirstName);
            criteria = criteriaBuilder.and(criteria, firstNamePredicate);
        }

        if(raisedBySecondName != null && !raisedBySecondName.equals("")){
            Predicate secondNamePredicate = criteriaBuilder.equal(ticketRoot.get("raisedBy").get("secondName"), raisedBySecondName);
            criteria = criteriaBuilder.and(criteria, secondNamePredicate);
        }
        // Assigned to name
        if(assignedToFirstName != null && !assignedToFirstName.equals("")){
            Predicate firstNamePredicate = criteriaBuilder.equal(ticketRoot.get("assignedTo").get("firstName"), assignedToFirstName);
            criteria = criteriaBuilder.and(criteria, firstNamePredicate);
        }

        if(assignedToSecondName != null && !assignedToSecondName.equals("")){
            Predicate secondNamePredicate = criteriaBuilder.equal(ticketRoot.get("assignedTo").get("secondName"), assignedToSecondName);
            criteria = criteriaBuilder.and(criteria, secondNamePredicate);
        }
        ticketQuery.where(criteria);
        return entityManager.createQuery(ticketQuery).getResultList();
    }
}
