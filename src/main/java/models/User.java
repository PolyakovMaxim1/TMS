package models;

import jdk.internal.instrumentation.TypeMapping;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "user_id")
    private long id;

    @Column (name = "user_name")
    private String name;

    @Column (name = "user_password")
    private String password;

    @Column (name = "count_make_bug")
    private int countMakeBug;

    private String email;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "role_id")
    private Role role;

    @OneToMany (mappedBy = "user")
    private Set<TicketAnswer> answers1;

    public User(String name, String password, String email, Role role){
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", countMakeBug=" + countMakeBug +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}
