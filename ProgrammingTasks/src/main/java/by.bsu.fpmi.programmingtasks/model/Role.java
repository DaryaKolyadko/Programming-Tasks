package by.bsu.fpmi.programmingtasks.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;

/**
 * Created by Даша on 19.10.2015.
 */
@Entity
@Table(name = "ROLE")
public class Role implements Serializable
{
    static final long serialVersionID = 1L;
    @Id
    @Column(name = "ROLE_NAME", nullable = false)
    private String roleName;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private HashSet<User_Role> Users = new HashSet<User_Role>(0);
}
