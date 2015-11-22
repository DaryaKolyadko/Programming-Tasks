package by.bsu.fpmi.kolyadkodarya.services;


import by.bsu.fpmi.kolyadkodarya.model.UserRole;

import java.util.List;
import java.util.Set;

public interface UserRoleService {
    void saveRole(UserRole role);

    Set<UserRole> listRoles();
    UserRole getRole(Long id);

    void deleteRole(Long id);
}
