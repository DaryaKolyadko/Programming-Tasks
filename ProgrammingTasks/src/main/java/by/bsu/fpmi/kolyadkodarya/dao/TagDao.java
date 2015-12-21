package by.bsu.fpmi.kolyadkodarya.dao;

import by.bsu.fpmi.kolyadkodarya.model.Tag;
import by.bsu.fpmi.kolyadkodarya.model.User;

import java.util.List;

/**
 * Created by Даша on 20.12.2015.
 */
public interface TagDao
{
    Tag getById(int id);
    Tag getByName(String tagName);
    void update(Tag tag);
    Tag save(Tag tag);
    List<Tag> listTags();
}
