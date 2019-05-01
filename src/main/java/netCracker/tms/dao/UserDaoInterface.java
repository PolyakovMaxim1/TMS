package netCracker.tms.dao;

import netCracker.tms.models.User;

public interface UserDaoInterface {

    public User findById(long id);

    public void save(User user);

    public void update(User user);

    public void delete(User user);

}
