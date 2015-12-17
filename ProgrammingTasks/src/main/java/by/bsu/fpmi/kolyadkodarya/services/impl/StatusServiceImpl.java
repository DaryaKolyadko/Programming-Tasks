package by.bsu.fpmi.kolyadkodarya.services.impl;

import by.bsu.fpmi.kolyadkodarya.dao.StatusDao;
import by.bsu.fpmi.kolyadkodarya.dao.UserDao;
import by.bsu.fpmi.kolyadkodarya.model.Status;
import by.bsu.fpmi.kolyadkodarya.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Даша on 11.12.2015.
 */
@Transactional
@Service("statusService")
public class StatusServiceImpl implements StatusService
{
    @Autowired
    private StatusDao statusDao;

    @Override
    public Status getStatusById(int id)
    {
        return statusDao.getById(id);
    }

    @Override
    public void updateStatus(Status status)
    {
        statusDao.update(status);
    }

    @Override
    public Status saveStatus(Status status)
    {
        return statusDao.save(status);
    }

    @Override
    public List<Status> statusList()
    {
        return statusDao.statusList();
    }

    @Override
    public Status getDefaultStatus()
    {
        return statusDao.getDefaultStatus();
    }
}
