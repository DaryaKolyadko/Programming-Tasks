package by.bsu.fpmi.kolyadkodarya.dao.impl;

import by.bsu.fpmi.kolyadkodarya.dao.CategoryDao;
import by.bsu.fpmi.kolyadkodarya.model.Category;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Даша on 07.12.2015.
 */
@Repository
public class CategoryDaoImpl implements CategoryDao
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Category getById(int id)
    {
        List<Category> categories;
        categories = sessionFactory.getCurrentSession().createQuery("FROM Category WHERE categoryId=?").setParameter(0, id).list();

        if (categories.size() > 0)
        {
            return categories.get(0);
        } else
        {
            return null;
        }
    }

    @Override
    public void update(Category category)
    {
        sessionFactory.getCurrentSession().update(category);
    }

    @Override
    public Category save(Category category)
    {
        sessionFactory.getCurrentSession().save(category);
        return category;
    }

    @Override
    public List<Category> listCategories()
    {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(Category.class);
        c.addOrder(Order.asc("categoryId"));
        return c.list();
    }
}
