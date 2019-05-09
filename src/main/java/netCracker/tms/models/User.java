package netCracker.tms.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @Column (name = "user_id")
//    @GenericGenerator (name = "hilogen", strategy = "increment")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @Column (name = "user_first_name")
    private String firstName;

    @Column (name = "user_second_name")
    private String secondName;

    @Column (name = "user_login")
    private String login;

    @Column (name = "user_password")
    private String password;

    @Column (name = "count_make_bug")
    private int countMakeBug;

    @Column (name = "user_gender")
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    private String email;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.ORDINAL)
    private Set<Role> roles;

    @OneToMany (mappedBy = "user")
    private Set<TicketAnswer> answers;

    @OneToMany (mappedBy = "raisedBy")
    private Set<Ticket> tickets;

    public User(String firstName, String secondName, String login, String password, Gender gender, String email, int countMakeBug) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.countMakeBug = countMakeBug;
    }

    public User(String firstName, String secondName, String login, String password, Gender gender, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
        this.gender = gender;
        this.email = email;
    }

    public User(){

    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Set<TicketAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<TicketAnswer> answers) {
        this.answers = answers;
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
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", countMakeBug=" + countMakeBug +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
