package by.bsu.fpmi.kolyadkodarya.services;

import by.bsu.fpmi.kolyadkodarya.model.Tag;
import by.bsu.fpmi.kolyadkodarya.model.Task;

import java.util.List;

/**
 * Created by Даша on 20.12.2015.
 */
public interface TagService
{
    Tag getById(int id);
    void update(Tag tag);
    void save(Tag tag);
    Tag addNewTag(Tag newTag, Task task) throws NullPointerException;
    List<Tag> listTags();
    Tag getByName(String name);
}
