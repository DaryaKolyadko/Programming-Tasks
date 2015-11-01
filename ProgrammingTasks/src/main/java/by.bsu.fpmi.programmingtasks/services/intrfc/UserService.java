package by.bsu.fpmi.programmingtasks.services.intrfc;

import by.bsu.fpmi.programmingtasks.model.AppUser;

/**
 * Created by Даша on 01.11.2015.
 */
public interface UserService
{
    public AppUser readUserByUsername(String username);
}
