package by.bsu.fpmi.kolyadkodarya.services;

import by.bsu.fpmi.kolyadkodarya.model.Status;

import java.util.List;

/**
 * Created by Даша on 11.12.2015.
 */
public interface StatusService
{
    Status getStatusById(int id);
    void updateStatus(Status status);
    Status saveStatus(Status status);
    List<Status> statusList();
    Status getDefaultStatus();
}
