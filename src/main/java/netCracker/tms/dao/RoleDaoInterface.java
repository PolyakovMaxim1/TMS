package netCracker.tms.dao;

import netCracker.tms.models.Role;

public interface RoleDaoInterface {

    public Role findById(long id);

    public void save(Role role);

    public void update(Role role);

    public void delete(Role role);

}
