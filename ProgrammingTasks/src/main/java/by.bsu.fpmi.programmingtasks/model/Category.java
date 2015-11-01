package by.bsu.fpmi.programmingtasks.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Даша on 21.10.2015.
 */
@Entity
@Table(name = "TASK_CATEGORY")
public class Category implements Serializable
{
    static final long serialVersionID = 1L;
    @Column(name = "CATEGORY_NAME")
    String name;
    @OneToMany(fetch=FetchType.EAGER, mappedBy = "task", cascade=CascadeType.ALL)
    Task task;
}
