package by.bsu.fpmi.programmingtasks.dao.impl;

import by.bsu.fpmi.programmingtasks.dao.intrfc.UserDao;
import by.bsu.fpmi.programmingtasks.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Даша on 01.11.2015.
 */
public class UserDaoImpl implements UserDao
{
    @Autowired //connect to xml.
    private SessionFactory sessionFactory;

    @Override
    public User getByUsername(String username)
    {
        return (User) sessionFactory.getCurrentSession().get(User.class, username);
    }

    @Override
    public void update(User user)
    {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public User save(User user)
    {
        sessionFactory.getCurrentSession().save(user);
        return user;
    }
}
