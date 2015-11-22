package by.bsu.fpmi.kolyadkodarya.dao.impl;

import by.bsu.fpmi.kolyadkodarya.dao.UserDao;
import by.bsu.fpmi.kolyadkodarya.model.User;
import by.bsu.fpmi.kolyadkodarya.model.UserRole;
import by.bsu.fpmi.kolyadkodarya.utils.CustomPasswordEncoder;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getByUsername(String username) {
        //return (User) sessionFactory.getCurrentSession().get(User.class, username);
        List<User> users = new ArrayList<User>();
        users = sessionFactory.getCurrentSession().createQuery("FROM User WHERE username=?").setParameter(0, username).list();
        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }

    }
    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public User save(User user) {
        user.setPassword(new CustomPasswordEncoder("sha-256").encodePassword(user.getUsername(), user.getPassword()));
        Set<UserRole> userRoleSet = user.getUserRolesSet();
        userRoleSet.add(new UserRole(user, "USER"));
        user.setUserRolesSet(userRoleSet);

        sessionFactory.getCurrentSession().save(user);
        return user;
    }

    @Override
    public List<User> listUsers() {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(User.class);
        c.addOrder(Order.asc("username"));
        return c.list();
    }

//    public void cr(){
//        Criteria cr = sessionFactory.getCurrentSession().createCriteria(User.class);
//        cr.add(Restrictions.eq("username", "admin"));
//        cr.list();
//    }
}
