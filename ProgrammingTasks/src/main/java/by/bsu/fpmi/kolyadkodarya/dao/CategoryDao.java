package by.bsu.fpmi.kolyadkodarya.dao;

import by.bsu.fpmi.kolyadkodarya.model.Category;

import java.util.List;

/**
 * Created by Даша on 07.12.2015.
 */
public interface CategoryDao
{
    Category getById(Long id);

    void update(Category category);

    Category save(Category category);

    List<Category> listCategories();
}
