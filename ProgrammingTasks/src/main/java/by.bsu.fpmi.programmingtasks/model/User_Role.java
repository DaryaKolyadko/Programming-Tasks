package by.bsu.fpmi.programmingtasks.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Created by Даша on 19.10.2015.
 */
@Entity
@Table(name = "USER_ROLE",uniqueConstraints = @UniqueConstraint(columnNames = {"ROLE", "USER_NAME"}))
public class User_Role implements Serializable
{
    static final long serialVersionID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="USER_ROLE_ID")
    private long id;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ROLE_NAME")
    private Role role;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="USER_NAME", nullable=false)
    private User user;

    //getter, setter, 2 construtors(withowt params, with params)
}
