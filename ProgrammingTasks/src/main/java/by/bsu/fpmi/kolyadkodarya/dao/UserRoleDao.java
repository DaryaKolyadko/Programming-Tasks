package by.bsu.fpmi.kolyadkodarya.dao;


import by.bsu.fpmi.kolyadkodarya.model.UserRole;

import java.util.List;
import java.util.Set;

public interface UserRoleDao {
    public void saveRole(UserRole role);

    public Set<UserRole> listRoles();
    public UserRole getRole(Long id);

    public void deleteRole(Long id);
}
