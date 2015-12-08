package by.bsu.fpmi.kolyadkodarya.services.impl;

import by.bsu.fpmi.kolyadkodarya.dao.UserDao;
import by.bsu.fpmi.kolyadkodarya.model.User;
import by.bsu.fpmi.kolyadkodarya.model.UserRole;
import by.bsu.fpmi.kolyadkodarya.utils.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import by.bsu.fpmi.kolyadkodarya.services.UserService;

import java.util.List;


@Service ("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User readUserByUsername(String username) {
        return userDao.getByUsername(username);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    private boolean usernameExists(final String name) {
        final User user = userDao.getByUsername(name);
        return user != null;
    }

    @Override
    public User registerNewUserAccount(User accountDto) throws NullPointerException {
        if (usernameExists(accountDto.getUsername())) {
            throw new NullPointerException("Account with that username: " + accountDto.getUsername() + " already exists!");
        }
        final User user = new User();
        user.setStatus(accountDto.getStatus());
        user.setUsername(accountDto.getUsername());
        user.setPassword(new CustomPasswordEncoder("sha-256").encodePassword(accountDto.getPassword(), accountDto.getUsername()));
        user.setEnabled(true);
        user.setFirstname(accountDto.getFirstname());
        user.setLastname(accountDto.getLastname());
        user.getUserRolesSet().add(new UserRole(user, "USER"));
        return userDao.save(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}
