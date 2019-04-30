package models;

import javax.persistence.*;

@Entity
@Table (name = "object")
public class Object {
    @Id
    @Column (name = "id_object")
    private long id;

    @Column (name = "name_object")
    private String name;

    public Object(){

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
        return "Object{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
