package netCracker.tms.models;

import javax.persistence.*;

@Entity
@Table (name = "User_status")
public class UserStatus {
    @Id
    @Column (name = "id_user_status")
    private long id;

    @Column (name = "user_status_name")
    private String userStatusName;

    public UserStatus(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserStatusName() {
        return userStatusName;
    }

    public void setUserStatusName(String userStatusName) {
        this.userStatusName = userStatusName;
    }

    @Override
    public String toString() {
        return "UserStatus{" +
                "id=" + id +
                ", userStatusName='" + userStatusName + '\'' +
                '}';
    }
}
