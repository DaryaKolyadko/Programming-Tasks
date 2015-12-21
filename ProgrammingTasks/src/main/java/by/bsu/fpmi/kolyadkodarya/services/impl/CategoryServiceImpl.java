package by.bsu.fpmi.kolyadkodarya.services.impl;

import by.bsu.fpmi.kolyadkodarya.dao.CategoryDao;
import by.bsu.fpmi.kolyadkodarya.model.Category;
import by.bsu.fpmi.kolyadkodarya.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Даша on 07.12.2015.
 */

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService
{
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category getById(int id)
    {
        return categoryDao.getById(id);
    }

    @Override
    public Category getByName(String name)
    {
        return categoryDao.getByName(name);
    }

    @Override
    public void update(Category category)
    {
        categoryDao.update(category);
    }

    @Override
    public Category save(Category category)
    {
        return categoryDao.save(category);
    }

    @Override
    public List<Category> listCategories()
    {
        return categoryDao.listCategories();
    }
}
