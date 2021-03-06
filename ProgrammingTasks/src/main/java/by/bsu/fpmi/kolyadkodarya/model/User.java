package by.bsu.fpmi.kolyadkodarya.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "APP_USER")
public class User implements Serializable{
    static final long serialVersionUID = 1L;

    @Id
    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserRole> userRolesSet = new HashSet<UserRole>(0);

    @Column(name = "ENABLED", nullable = false)
    private boolean enabled;

    @Column(name = "FIRSTNAME", nullable = false)
    private String firstname;

    @Column(name = "LASTNAME", nullable = false)
    private String lastname;

    @ManyToOne
    @JoinColumn(name = "STATUS_ID", nullable = true)
    private Status status;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "userCreator")
    private Set<Task> tasks = new HashSet<Task>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "SOLVE_USER_TASK", joinColumns = {
            @JoinColumn(name = "USER_ID", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "TASK_ID",
                    nullable = false)})
    private Set<Task> solvedTasks = new HashSet<Task>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserRole> getUserRolesSet() {
        return userRolesSet;
    }

    public void setUserRolesSet(Set<UserRole> userRolesSet) {
        this.userRolesSet = userRolesSet;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Status getStatus()
    {
        return status;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }

    public Set<Task> getTasks()
    {
        return tasks;
    }

    public void setTasks(Set<Task> tasks)
    {
        this.tasks = tasks;
    }

    public Set<Task> getSolvedTasks()
    {
        return solvedTasks;
    }

    public void setSolvedTasks(Set<Task> solvedTasks)
    {
        this.solvedTasks = solvedTasks;
    }
}
