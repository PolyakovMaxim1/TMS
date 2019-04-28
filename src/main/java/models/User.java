package models;

import jdk.internal.instrumentation.TypeMapping;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "user_id")
    private int id;
    @Column (name = "user_name")
    private String name;
    @Column (name = "user_password")
    private String password;
    private String email;

    @OneToOne (mappedBy = "role_id", fetch = FetchType.LAZY)
    @JoinColumn (name = "role")
    private Role role;

    public User(String name, String password, String email, Role role){
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
