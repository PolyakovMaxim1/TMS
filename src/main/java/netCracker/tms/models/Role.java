package netCracker.tms.models;
import javax.persistence.*;

@Entity
@Table (name = "role")
public class Role {

    @Id
    @Column (name = "role_id")
    private long id;

    @Column (name = "role_name")
    private String name;

    public Role(){

    }
    public Role(long id, String name){
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return this.name;
    }
}
