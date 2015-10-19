package by.bsu.fpmi.programmingtasks.model;

import javax.persistence.*;

/**
 * Created by Даша on 19.10.2015.
 */
@Entity
@Table(name = "APP_USER")
public class AppUser
{
    static final long serialVersionID = 1L;
    @Id
    @Column(name = "USER_NAME")
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    User user;
    @Column(name = "RATING")
    int rating;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "statusText")
    private UserStatusText statusText;

//    public ICollection<Comment> Comments { get; set; }
//    public ICollection<TaskRating> Ratings { get; set; }
//    public ICollection<ProgrammingTask> Tasks { get; set; }
//    public ICollection<UserSolved> UserSolvedList { get; set; }
}
