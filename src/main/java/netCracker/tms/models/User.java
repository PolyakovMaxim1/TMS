package netCracker.tms.models;

import org.hibernate.annotations.GenericGenerator;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column (name = "user_id")
//    @GenericGenerator (name = "hilogen", strategy = "increment")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @Column (name = "user_name")
    private String name;

    @Column (name = "user_login")
    private String login;

    @Column (name = "user_password")
    private String password;

    @Column (name = "count_make_bug")
    private int countMakeBug;

    private String email;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.ORDINAL)
    private Set<Role> roles;

    @OneToMany (mappedBy = "user")
    private Set<TicketAnswer> answers;

    @OneToMany (mappedBy = "raisedBy")
    private Set<Ticket> tickets;

    public User(String name, String password, String email, int countMakeBug){
        this.name = name;
        this.password = password;
        this.email = email;
        this.countMakeBug = countMakeBug;
    }
    public User(long id, String name, String password, String email, Role role){
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }
    public User(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Set<TicketAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<TicketAnswer> answers) {
        this.answers = answers;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCountMakeBug() {
        return countMakeBug;
    }

    public void setCountMakeBug(int countMakeBug) {
        this.countMakeBug = countMakeBug;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", countMakeBug=" + countMakeBug +
                ", email='" + email + '\'' +
                '}';
    }
}
