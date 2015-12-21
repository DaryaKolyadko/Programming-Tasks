package by.bsu.fpmi.kolyadkodarya.dao;

import by.bsu.fpmi.kolyadkodarya.model.ComplexityLevel;

import java.util.List;

/**
 * Created by Даша on 20.12.2015.
 */
public interface ComplexityLevelDao
{
    ComplexityLevel getById(int id);

    ComplexityLevel getByName(String name);

    void update(ComplexityLevel complexityLevel);

    ComplexityLevel save(ComplexityLevel complexityLevel);

    List<ComplexityLevel> listComplexityLevels();
}
