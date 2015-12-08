package by.bsu.fpmi.kolyadkodarya.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Даша on 07.12.2015.
 */
@Entity
@Table(name = "STATUS")
public class Status
{
    @Id
    @Column(name = "STATUS_ID", nullable = false)
    private String id;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "status")
    private Set<User> users = new HashSet<User>();

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public Set<User> getUsers()
    {
        return users;
    }

    public void setUsers(Set<User> users)
    {
        this.users = users;
    }
}
