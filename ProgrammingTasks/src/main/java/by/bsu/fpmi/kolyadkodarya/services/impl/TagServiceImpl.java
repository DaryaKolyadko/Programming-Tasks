package by.bsu.fpmi.kolyadkodarya.services.impl;

import by.bsu.fpmi.kolyadkodarya.dao.TagDao;
import by.bsu.fpmi.kolyadkodarya.model.Tag;
import by.bsu.fpmi.kolyadkodarya.model.Task;
import by.bsu.fpmi.kolyadkodarya.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by Даша on 20.12.2015.
 */
@Service("tagService")
@Transactional
public class TagServiceImpl implements TagService
{
    @Autowired
    private TagDao tagDao;

    @Override
    public Tag getById(int id)
    {
        return tagDao.getById(id);
    }

    @Override
    public void update(Tag tag)
    {
        tagDao.update(tag);
    }

    @Override
    public void save(Tag tag)
    {
        tagDao.save(tag);
    }

    @Override
    public Tag addNewTag(Tag newTag, Task task) throws NullPointerException
    {
        Set<Task> tasks = newTag.getTasks();
        tasks.add(task);
        newTag.setTasks(tasks);
        tagDao.save(newTag);
        return newTag;
    }

    @Override
    public List<Tag> listTags()
    {
        return tagDao.listTags();
    }

    @Override
    public Tag getByName(String name)
    {
        final Tag tag = tagDao.getByName(name);
        return tag;
    }
}