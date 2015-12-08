package by.bsu.fpmi.kolyadkodarya.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Даша on 07.12.2015.
 */
@Entity
@Table(name = "COMPLEXITY_LEVEL")
public class ComplexityLevel
{
    @Id
    @Column(name = "COMPLEXITY_LEVEL_ID", nullable = false)
    private Long complexityLevelId;

    @Column(name = "NAME", nullable = false)
    private String complexityLevelName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "complexityLevel")
    private Set<Task> tasks = new HashSet<Task>();

    public Long getComplexityLevelId()
    {
        return complexityLevelId;
    }

    public void setComplexityLevelId(Long complexityLevelId)
    {
        this.complexityLevelId = complexityLevelId;
    }

    public String getComplexityLevelName()
    {
        return complexityLevelName;
    }

    public void setComplexityLevelName(String complexityLevelName)
    {
        this.complexityLevelName = complexityLevelName;
    }

    public Set<Task> getTasks()
    {
        return tasks;
    }

    public void setTasks(Set<Task> tasks)
    {
        this.tasks = tasks;
    }
}