package by.bsu.fpmi.kolyadkodarya.services;

import by.bsu.fpmi.kolyadkodarya.model.ComplexityLevel;

import java.util.List;

/**
 * Created by Даша on 20.12.2015.
 */
public interface ComplexityLevelService
{
    ComplexityLevel getById(int id);

    void update(ComplexityLevel complexityLevel);

    ComplexityLevel save(ComplexityLevel complexityLevel);

    List<ComplexityLevel> listComplexityLevels();

    ComplexityLevel getByName(String name);
}
