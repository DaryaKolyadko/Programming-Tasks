package by.bsu.fpmi.kolyadkodarya.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Даша on 07.12.2015.
 */
@Entity
@Table(name = "TAG")
public class Tag
{
    @Id
    @Column(name = "TAG_ID", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long tagId;

    @Column(name = "TAG", nullable = false)
    private String tagName;

    public Set<Task> getTasks()
    {
        return tasks;
    }

    public void setTasks(Set<Task> tasks)
    {
        this.tasks = tasks;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "TAG_TASK", joinColumns = {
            @JoinColumn(name = "TAG_ID", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "TASK_ID",
                    nullable = false)})
    private Set<Task> tasks = new HashSet<Task>();

    public Long getTagId()
    {
        return tagId;
    }

    public void setTagId(Long tagId)
    {
        this.tagId = tagId;
    }

    public String getTagName()
    {
        return tagName;
    }

    public void setTagName(String tagName)
    {
        this.tagName = tagName;
    }
}