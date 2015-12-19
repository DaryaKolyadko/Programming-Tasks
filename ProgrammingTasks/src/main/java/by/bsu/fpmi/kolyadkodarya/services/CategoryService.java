package by.bsu.fpmi.kolyadkodarya.services;

import by.bsu.fpmi.kolyadkodarya.model.Category;

import java.util.List;

/**
 * Created by Даша on 07.12.2015.
 */
public interface CategoryService
{
    Category getById(int id);

    void update(Category category);

    Category save(Category category);

    List<Category> listCategories();
}
