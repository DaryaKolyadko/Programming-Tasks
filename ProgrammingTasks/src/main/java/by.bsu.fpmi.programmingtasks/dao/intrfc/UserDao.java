package by.bsu.fpmi.programmingtasks.dao.intrfc;

import by.bsu.fpmi.programmingtasks.model.User;

/**
 * Created by Даша on 01.11.2015.
 */
public interface UserDao
{
    User getByUsername(String username);
    void update(User user);
    User save(User user);
}
