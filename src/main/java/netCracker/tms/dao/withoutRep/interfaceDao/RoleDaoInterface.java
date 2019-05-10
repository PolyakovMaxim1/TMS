package netCracker.tms.dao.withoutRep.interfaceDao;

import netCracker.tms.models.Enums.Role;

public interface RoleDaoInterface {

    public Role findById(long id);

    public void save(Role role);

    public void update(Role role);

    public void delete(Role role);

}
