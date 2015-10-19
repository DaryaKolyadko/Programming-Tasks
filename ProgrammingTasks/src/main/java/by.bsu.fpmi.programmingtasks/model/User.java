package by.bsu.fpmi.programmingtasks.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;

/**
 * Created by Даша on 19.10.2015.
 */
@Entity
@Table(name="USER_SECURITY")
public class User implements Serializable
{
    static final long serialVersionID = 1L;
    @Id
    @Column(name="USER_NAME", nullable=false)
    private String userName;
    @Column(name="PASSWORD", nullable=false)
    private String password;
    @OneToMany(fetch=FetchType.EAGER, mappedBy="user", cascade=CascadeType.ALL)
    private HashSet<User_Role> Roles = new HashSet<User_Role>(0);
     // +getters, setters
}
