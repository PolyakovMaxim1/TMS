package netCracker.tms.dao.withoutRep.interfaceDao;

import netCracker.tms.models.User;
import java.util.*;

public interface UserDaoInterface {

    public List<User> allUsers();

    public User findById(long id);

    public void save(User user);

    public void update(User user);

    public void delete(User user);

}
