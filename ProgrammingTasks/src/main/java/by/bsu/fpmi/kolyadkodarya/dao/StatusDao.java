package by.bsu.fpmi.kolyadkodarya.dao;

import by.bsu.fpmi.kolyadkodarya.model.Category;
import by.bsu.fpmi.kolyadkodarya.model.Status;

import java.util.List;

/**
 * Created by Даша on 11.12.2015.
 */
public interface StatusDao
{
    Status getById(int id);
    void update(Status status);
    Status save(Status status);
    List<Status> statusList();
    Status getDefaultStatus();
}
