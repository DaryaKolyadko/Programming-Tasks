package by.bsu.fpmi.kolyadkodarya.dao;

import by.bsu.fpmi.kolyadkodarya.model.User;

import java.util.List;

/**
 * Created by user on 24.10.2015.
 */
public interface UserDao {
    User getByUsername(String username);
    void update(User user);
    User save(User user);
    List<User> listUsers();
}
