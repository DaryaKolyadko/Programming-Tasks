package by.bsu.fpmi.kolyadkodarya.dao.impl;

import by.bsu.fpmi.kolyadkodarya.dao.UserRoleDao;
import by.bsu.fpmi.kolyadkodarya.model.User;
import by.bsu.fpmi.kolyadkodarya.model.UserRole;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserRoleDaoImpl implements UserRoleDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveRole(UserRole role) {

        sessionFactory.getCurrentSession().merge(role);
    }

    @Override
    public Set<UserRole> listRoles() {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(UserRole.class);
        c.addOrder(Order.desc("role"));
        List<UserRole> list = c.list();
        Set<UserRole> setRoles = new HashSet<UserRole>();
        for(UserRole role : list){
            if (!setRoles.contains(role))
                setRoles.add(role);
        }
        return setRoles;
    }

    @Override
    public UserRole getRole(Long id) {
        return (UserRole) sessionFactory.getCurrentSession().get(UserRole.class, id);
    }

    @Override
    public void deleteRole(Long id) {
        UserRole role = getRole(id);
        if (null != role) {
            sessionFactory.getCurrentSession().delete(role);
        }
    }
}
