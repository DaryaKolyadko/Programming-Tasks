package by.bsu.fpmi.kolyadkodarya.dao.impl;

import by.bsu.fpmi.kolyadkodarya.dao.TaskDao;
import by.bsu.fpmi.kolyadkodarya.model.Task;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Даша on 20.12.2015.
 */
@Repository
public class TaskDaoImpl implements TaskDao
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Task getById(int id)
    {
        return (Task) sessionFactory.getCurrentSession().get(Task.class, id);
    }

    @Override
    public void update(Task task)
    {
        sessionFactory.getCurrentSession().update(task);
    }

    @Override
    public Task save(Task task)
    {
        sessionFactory.getCurrentSession().save(task);
        return task;
    }

    @Override
    public List<Task> listTasks()
    {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(Task.class);
        c.addOrder(Order.asc("task_id"));
        return c.list();
    }

    @Override
    public void delete(int id)
    {
        Task task = getById(id);
        if (null != task) {
            sessionFactory.getCurrentSession().delete(task);
        }
    }
}
