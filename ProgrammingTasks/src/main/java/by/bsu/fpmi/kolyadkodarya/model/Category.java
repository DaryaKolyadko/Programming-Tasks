package by.bsu.fpmi.kolyadkodarya.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Даша on 07.12.2015.
 */
@Entity
@Table(name = "CATEGORY")
public class Category
{
    @Id
    @Column(name = "CATEGORY_ID", nullable = false)
    private Long categoryId;

    @Column(name = "NAME", nullable = false)
    private String categoryName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private Set<Task> tasks = new HashSet<Task>();

    public Long getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(Long categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
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
