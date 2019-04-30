package models;

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

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "status_id")
    private TicketStatus status;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "category_id")
    private TicketCategory category;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "priority_id")
    private TicketPriority priority;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "author_id")
    private User author;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "responsible_id")
    private User responsible;

    @Column (name = "date_of_discovery")
    private Date dateDiscovery;

    @Column (name = "product_version_discovery")
    private String discoveryProductVersion;

    @Column (name = "product_version_fixed")
    private String fixedProductVersion;

    @Column (name = "description_detection_problem")
    private String detectionProblemDescription;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "object_id")
    private Object object;

    @OneToMany (mappedBy = "ticket")
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

    public TicketCategory getCategory() {
        return category;
    }

    public void setCategory(TicketCategory category) {
        this.category = category;
    }

    public TicketPriority getPriority() {
        return priority;
    }

    public void setPriority(TicketPriority priority) {
        this.priority = priority;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getResponsible() {
        return responsible;
    }

    public void setResponsible(User responsible) {
        this.responsible = responsible;
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

    public Set<TicketAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<TicketAnswer> answers) {
        this.answers = answers;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", category=" + category +
                ", priority=" + priority +
                ", author=" + author +
                ", responsible=" + responsible +
                ", dateDiscovery=" + dateDiscovery +
                ", discoveryProductVersion='" + discoveryProductVersion + '\'' +
                ", fixedProductVersion='" + fixedProductVersion + '\'' +
                ", detectionProblemDescription='" + detectionProblemDescription + '\'' +
                ", object=" + object +
                '}';
    }
}
