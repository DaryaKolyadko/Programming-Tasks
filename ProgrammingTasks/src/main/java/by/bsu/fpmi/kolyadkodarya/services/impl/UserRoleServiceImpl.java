package by.bsu.fpmi.kolyadkodarya.services.impl;

import by.bsu.fpmi.kolyadkodarya.dao.UserRoleDao;
import by.bsu.fpmi.kolyadkodarya.model.UserRole;
import by.bsu.fpmi.kolyadkodarya.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by user on 10.11.2015.
 */
@Transactional
@Service("roleService")
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleDao roleDao;

    @Override
    public void saveRole(UserRole role) {
        roleDao.saveRole(role);
    }

    @Override
    public Set<UserRole> listRoles() {
        return roleDao.listRoles();
    }

    @Override
    public UserRole getRole(Long id) {
        return roleDao.getRole(id);
    }

    @Override
    public void deleteRole(Long id) {
        roleDao.deleteRole(id);
    }
}
