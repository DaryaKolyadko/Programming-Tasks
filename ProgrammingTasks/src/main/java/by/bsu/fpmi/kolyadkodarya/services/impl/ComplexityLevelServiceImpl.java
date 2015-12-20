package by.bsu.fpmi.kolyadkodarya.services.impl;

import by.bsu.fpmi.kolyadkodarya.dao.ComplexityLevelDao;
import by.bsu.fpmi.kolyadkodarya.model.ComplexityLevel;
import by.bsu.fpmi.kolyadkodarya.services.ComplexityLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Даша on 20.12.2015.
 */
@Service("categoryService")
@Transactional
public class ComplexityLevelServiceImpl implements ComplexityLevelService
{
    @Autowired
    private ComplexityLevelDao complexityLevelDao;

    @Override
    public ComplexityLevel getById(int id)
    {
        return complexityLevelDao.getById(id);
    }

    @Override
    public void update(ComplexityLevel complexityLevel)
    {
        complexityLevelDao.update(complexityLevel);
    }

    @Override
    public ComplexityLevel save(ComplexityLevel complexityLevel)
    {
        return complexityLevelDao.save(complexityLevel);
    }

    @Override
    public List<ComplexityLevel> listComplexityLevels()
    {
        return complexityLevelDao.listComplexityLevels();
    }
}
