package by.bsu.fpmi.programmingtasks.services.impl;

import by.bsu.fpmi.programmingtasks.dao.intrfc.UserDao;
import by.bsu.fpmi.programmingtasks.model.AppUser;
import by.bsu.fpmi.programmingtasks.model.User;
import by.bsu.fpmi.programmingtasks.services.intrfc.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Даша on 01.11.2015.
 */
@Service("userservice")
@Transactional
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDao userDao;

    @Override
    public User readUserByUsername(String username) {
        return userDao.getByUsername(username);
    }
}