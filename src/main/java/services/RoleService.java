package services;

import dao.*;
import models.*;

public class RoleService {

    private RoleDaoImplements roleDao = new RoleDaoImplements();

    public RoleService() {
    }

    public Role findUser(int id) {
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