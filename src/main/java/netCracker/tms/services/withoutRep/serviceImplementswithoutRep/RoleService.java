package netCracker.tms.services.withoutRep.serviceImplementswithoutRep;

import netCracker.tms.dao.withoutRep.implementsDao.RoleDaoImplements;
import netCracker.tms.dao.withoutRep.interfaceDao.RoleDaoInterface;
import netCracker.tms.models.Enums.Role;
import netCracker.tms.services.withoutRep.serviceInterfacewithoutRep.RoleServiceInterface;

public class RoleService implements RoleServiceInterface {

    private RoleDaoInterface roleDao = new RoleDaoImplements();

    public RoleService() {
    }

    public Role findRole(long id) {
        return roleDao.findById(id);
    }

    public void saveRole(Role role) {
        roleDao.save(role);
    }

    public void deleteRole(Role role) {
        roleDao.delete(role);
    }

    public void updateRole(Role role) {
        roleDao.update(role);
    }

}