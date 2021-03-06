package netCracker.tms.models;
import netCracker.tms.models.Enums.UserStatus;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table (name = "user_status_info")
public class UserStatusInfo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_status_info")
    private long id;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "user_status_id")
    @Enumerated(EnumType.ORDINAL)
    private UserStatus userStatus;

    @Column(name = "loged_in")
    private Date lodedIn;

    @Column(name = "loged_out")
    private Date lodedOut;

    public UserStatusInfo(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public Date getLodedIn() {
        return lodedIn;
    }

    public void setLodedIn(Date lodedIn) {
        this.lodedIn = lodedIn;
    }

    public Date getLodedOut() {
        return lodedOut;
    }

    public void setLodedOut(Date lodedOut) {
        this.lodedOut = lodedOut;
    }

    @Override
    public String toString() {
        return "StatusInfo{" +
                "id=" + id +
                ", user=" + user +
                ", userStatus=" + userStatus +
                ", lodedIn=" + lodedIn +
                ", lodedOut=" + lodedOut +
                '}';
    }
}
