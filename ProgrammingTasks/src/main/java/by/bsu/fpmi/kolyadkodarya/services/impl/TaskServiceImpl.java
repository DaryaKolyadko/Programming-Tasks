package by.bsu.fpmi.kolyadkodarya.services.impl;

import by.bsu.fpmi.kolyadkodarya.dao.TaskDao;
import by.bsu.fpmi.kolyadkodarya.model.Task;
import by.bsu.fpmi.kolyadkodarya.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Даша on 20.12.2015.
 */

@Service("taskService")
@Transactional
public class TaskServiceImpl implements TaskService
{
    @Autowired
    private TaskDao taskDao;

    @Override
    public Task getById(int id)
    {
        return taskDao.getById(id);
    }

    @Override
    public void update(Task task)
    {
        taskDao.update(task);
    }

    @Override
    public void save(Task task)
    {
        taskDao.save(task);
    }

    @Override
    public List<Task> listTasks()
    {
        return taskDao.listTasks();
    }

    @Override
    public void delete(int id)
    {
        taskDao.delete(id);
    }
}
