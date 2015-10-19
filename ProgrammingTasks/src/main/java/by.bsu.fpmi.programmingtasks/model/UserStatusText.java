package by.bsu.fpmi.programmingtasks.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Даша on 19.10.2015.
 */
@Entity
@Table(name="USER_STATUS_TEXT")
public class UserStatusText implements Serializable
{
    static final long serialVersionID = 1L;
    @Id
    @Column(name="STATUS_TEXT", nullable=false)
    private String statusText;
    @OneToMany(fetch=FetchType.EAGER, mappedBy = "user", cascade=CascadeType.ALL)
    private User user;
}
