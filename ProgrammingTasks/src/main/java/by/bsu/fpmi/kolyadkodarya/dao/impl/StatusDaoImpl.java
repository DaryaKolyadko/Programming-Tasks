package by.bsu.fpmi.kolyadkodarya.dao.impl;

import by.bsu.fpmi.kolyadkodarya.dao.StatusDao;
import by.bsu.fpmi.kolyadkodarya.model.Status;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Даша on 11.12.2015.
 */
@Repository
public class StatusDaoImpl implements StatusDao
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Status getById(int id)
    {
        List<Status> statuses = new ArrayList<Status>();
        statuses = sessionFactory.getCurrentSession().createQuery("FROM Status WHERE statusId=?").setParameter(0, id).list();
        if (statuses.size() > 0) {
            return statuses.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void update(Status status)
    {
        sessionFactory.getCurrentSession().update(status);
    }

    @Override
    public Status save(Status status)
    {
        sessionFactory.getCurrentSession().save(status);
        return status;
    }

    @Override
    public List<Status> statusList()
    {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(Status.class);
        c.addOrder(Order.asc("status_id"));
        return c.list();
    }

    @Override
    public Status getDefaultStatus()
    {
        return getById(1);
    }
}
