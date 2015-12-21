package by.bsu.fpmi.kolyadkodarya.dao.impl;

import by.bsu.fpmi.kolyadkodarya.dao.ComplexityLevelDao;
import by.bsu.fpmi.kolyadkodarya.model.ComplexityLevel;
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
public class ComplexityLevelDaoImpl implements ComplexityLevelDao
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ComplexityLevel getById(int id)
    {
        List<ComplexityLevel> complexityLevels;
        complexityLevels = sessionFactory.getCurrentSession().createQuery("FROM ComplexityLevel WHERE id=?")
                .setParameter(0, id).list();

        if (complexityLevels.size() > 0)
        {
            return complexityLevels.get(0);
        } else
        {
            return null;
        }
    }

    @Override
    public ComplexityLevel getByName(String complexityLevelName)
    {
        List<ComplexityLevel> complexityLevels;
        complexityLevels = sessionFactory.getCurrentSession().createQuery("FROM ComplexityLevel WHERE complexityLevelName=?").setParameter(0, complexityLevelName).list();
        if (complexityLevels.size() == 1) {
            return complexityLevels.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void update(ComplexityLevel complexityLevel)
    {
        sessionFactory.getCurrentSession().update(complexityLevel);
    }

    @Override
    public ComplexityLevel save(ComplexityLevel complexityLevel)
    {
        sessionFactory.getCurrentSession().save(complexityLevel);
        return complexityLevel;
    }

    @Override
    public List<ComplexityLevel> listComplexityLevels()
    {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(ComplexityLevel.class);
        c.addOrder(Order.asc("complexityLevelId"));
        return c.list();
    }
}
