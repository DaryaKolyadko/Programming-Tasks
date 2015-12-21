package by.bsu.fpmi.kolyadkodarya.model;

import javax.persistence.*;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Даша on 07.12.2015.
 */
@Entity
@Table(name = "TASK")
public class Task
{
    @Id
    @Column(name = "TASK_ID", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int taskId;

    @Column(name = "NAME", nullable = false)
    private String taskName;

    @Column(name = "TASK", nullable = false)
    private String task;

    @Column(name = "SOLUTION", nullable = false)
    private String solution;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "task")
    private Set<Comment> comments = new HashSet<Comment>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_CREATOR", nullable = false)
    private User userCreator;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COMP_LEVEL_ID", nullable = false)
    private ComplexityLevel complexityLevel;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "TAG_TASK", joinColumns = {
            @JoinColumn(name = "TASK_ID", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "TAG_ID",
                    nullable = false)})
    private Set<Tag> tags = new HashSet<Tag>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "SOLVE_USER_TASK", joinColumns = {
            @JoinColumn(name = "TASK_ID", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "USER_ID",
                    nullable = false)})
    private Set<User> usersSolved = new HashSet<User>();

    public int getTaskId()
    {
        return taskId;
    }

    public void setTaskId(int taskId)
    {
        this.taskId = taskId;
    }

    public String getTaskName()
    {
        return taskName;
    }

    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }

    public String getTask()
    {
        return task;
    }

    public void setTask(String task)
    {
        this.task = task;
    }

    public String getSolution()
    {
        return solution;
    }

    public void setSolution(String solution)
    {
        this.solution = solution;
    }

    public Set<Comment> getComments()
    {
        return comments;
    }

    public void setComments(Set<Comment> comments)
    {
        this.comments = comments;
    }

    public User getUserCreator()
    {
        return userCreator;
    }

    public void setUserCreator(User userCreator)
    {
        this.userCreator = userCreator;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public ComplexityLevel getComplexityLevel()
    {
        return complexityLevel;
    }

    public void setComplexityLevel(ComplexityLevel complexityLevel)
    {
        this.complexityLevel = complexityLevel;
    }

    public Set<Tag> getTags()
    {
        return tags;
    }

    public void setTags(Set<Tag> tags)
    {
        this.tags = tags;
    }

    public Set<User> getUsersSolved()
    {
        return usersSolved;
    }

    public void setUsersSolved(Set<User> usersSolved)
    {
        this.usersSolved = usersSolved;
    }
}