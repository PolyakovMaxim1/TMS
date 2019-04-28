package models;
import javax.persistence.*;

@Entity
@Table (name = "role")
public class Role {

    @Id
    @Column (name = "role_id")
    private int id;

    @Column (name = "role_name")
    private String name;

    public Role(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
