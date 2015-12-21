package by.bsu.fpmi.kolyadkodarya.dao;

import by.bsu.fpmi.kolyadkodarya.model.Task;

import java.util.List;

/**
 * Created by Даша on 20.12.2015.
 */
public interface TaskDao
{
    Task getById(int id);

    void update(Task task);

    Task save(Task task);

    List<Task> listTasks();

    void delete(int id);
}
