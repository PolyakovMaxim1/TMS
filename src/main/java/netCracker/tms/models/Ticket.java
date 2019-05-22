package netCracker.tms.models;

import netCracker.tms.models.Enums.TicketCategory;
import netCracker.tms.models.Enums.TicketPriority;
import netCracker.tms.models.Enums.TicketStatus;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@Entity
@Table (name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ticket_id")
    private long id;

    private String description;

    @Column (name = "status_id")
    @Enumerated (EnumType.ORDINAL)
    private TicketStatus status;

    @Column (name = "priority_id")
    @Enumerated (EnumType.ORDINAL)
    private TicketPriority priority;

    @Column (name = "category_id")
    @Enumerated (EnumType.ORDINAL)
    private TicketCategory category;

    // поднытый кем-то
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "raised_by_id")
    private User raisedBy;

    // ответственный за тикет, за его решение
    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "assigned_to_id")
    private User assignedTo;

    @Column (name = "date_of_discovery")
    private Date dateDiscovery;

    @Column (name = "product_version_discovery")
    private String discoveryProductVersion;

    @Column (name = "product_version_fixed")
    private String fixedProductVersion;

    @Column (name = "description_detection_problem")
    private String detectionProblemDescription;

    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "object_id")
    private Object object;

    @OneToMany (mappedBy = "ticket", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<TicketAnswer> answers;


    public Ticket(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public TicketPriority getPriority() {
        return priority;
    }

    public void setPriority(TicketPriority priority) {
        this.priority = priority;
    }

    public TicketCategory getCategory() {
        return category;
    }

    public void setCategory(TicketCategory category) {
        this.category = category;
    }

    public User getRaisedBy() {
        return raisedBy;
    }

    public void setRaisedBy(User raisedBy) {
        this.raisedBy = raisedBy;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Date getDateDiscovery() {
        return dateDiscovery;
    }

    public void setDateDiscovery(Date dateDiscovery) {
        this.dateDiscovery = dateDiscovery;
    }

    public String getDiscoveryProductVersion() {
        return discoveryProductVersion;
    }

    public void setDiscoveryProductVersion(String discoveryProductVersion) {
        this.discoveryProductVersion = discoveryProductVersion;
    }

    public String getFixedProductVersion() {
        return fixedProductVersion;
    }

    public void setFixedProductVersion(String fixedProductVersion) {
        this.fixedProductVersion = fixedProductVersion;
    }

    public String getDetectionProblemDescription() {
        return detectionProblemDescription;
    }

    public void setDetectionProblemDescription(String detectionProblemDescription) {
        this.detectionProblemDescription = detectionProblemDescription;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Set<TicketAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<TicketAnswer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", category=" + category +
                ", priority=" + priority +
                ", raisedBy=" + raisedBy +
                ", assignedTo=" + assignedTo +
                ", dateDiscovery=" + dateDiscovery +
                ", discoveryProductVersion='" + discoveryProductVersion + '\'' +
                ", fixedProductVersion='" + fixedProductVersion + '\'' +
                ", detectionProblemDescription='" + detectionProblemDescription + '\'' +
                ", object=" + object +
                '}';
    }
}
