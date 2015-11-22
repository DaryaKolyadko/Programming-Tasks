package by.bsu.fpmi.kolyadkodarya.services;


import by.bsu.fpmi.kolyadkodarya.model.User;

import java.util.List;

public interface UserService {
    User readUserByUsername(String username);
    void update(User user);
    void save(User user);
    User registerNewUserAccount(User accountDao) throws NullPointerException;
    List<User> listUsers();
}
