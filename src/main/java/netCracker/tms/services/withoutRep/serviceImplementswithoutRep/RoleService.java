package netCracker.tms.services.withoutRep.serviceImplementswithoutRep;

import netCracker.tms.dao.withoutRep.implementsDao.RoleDaoImplements;
import netCracker.tms.dao.withoutRep.interfaceDao.RoleDaoInterface;
import netCracker.tms.models.*;
import netCracker.tms.services.withoutRep.serviceInterfacewithoutRep.RoleServiceInterface;
import org.springframework.stereotype.Service;

public class RoleService implements RoleServiceInterface {

    private RoleDaoInterface roleDao = new RoleDaoImplements();

    public RoleService() {
    }

    public Role findUser(long id) {
        return roleDao.findById(id);
    }

    public void saveUser(Role role) {
        roleDao.save(role);
    }

    public void deleteUser(Role role) {
        roleDao.delete(role);
    }

    public void updateUser(Role role) {
        roleDao.update(role);
    }

}