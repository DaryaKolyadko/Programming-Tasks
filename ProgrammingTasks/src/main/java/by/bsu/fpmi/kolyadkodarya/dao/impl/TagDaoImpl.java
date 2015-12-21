package by.bsu.fpmi.kolyadkodarya.dao.impl;

import by.bsu.fpmi.kolyadkodarya.dao.TagDao;
import by.bsu.fpmi.kolyadkodarya.model.Tag;
import by.bsu.fpmi.kolyadkodarya.model.UserRole;
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
public class TagDaoImpl implements TagDao
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Tag getById(int id)
    {
        return (Tag) sessionFactory.getCurrentSession().get(Tag.class, id);
    }

    @Override
    public Tag getByName(String tagName)
    {
        List<Tag> tags;
        tags = sessionFactory.getCurrentSession().createQuery("FROM Tag WHERE tagName=?").setParameter(0, tagName).list();
        if (tags.size() == 1) {
            return tags.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void update(Tag tag)
    {
        sessionFactory.getCurrentSession().update(tag);
    }

    @Override
    public Tag save(Tag tag)
    {
        sessionFactory.getCurrentSession().save(tag);
        return tag;
    }

    @Override
    public List<Tag> listTags()
    {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(Tag.class);
        c.addOrder(Order.asc("tag_id"));
        return c.list();
    }
}