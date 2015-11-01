package by.bsu.fpmi.programmingtasks.services.impl;

import by.bsu.fpmi.programmingtasks.model.AppUser;
import by.bsu.fpmi.programmingtasks.model.UserRole;
import by.bsu.fpmi.programmingtasks.services.intrfc.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Даша on 26.10.2015.
 */

@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService
{
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException
    {
        AppUser appUser = userService.readUserByUsername(userName);
        if (appUser == null)
        {
            throw new UsernameNotFoundException("User not found!");
        }

        Set<GrantedAuthority> authorities = buildUserAuthorities(appUser.getUser().getRoles());
        return new org.springframework.security.core.userdetails.User(appUser.getUser().getUsername(),
                appUser.getUser().getPassword(), authorities);
    }

    private Set<GrantedAuthority> buildUserAuthorities(Set<UserRole> userRoles)
    {
        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<GrantedAuthority>();
        for (UserRole userRole : userRoles)
        {
            grantedAuthoritySet.add(new SimpleGrantedAuthority(userRole.getRole().getRoleName()));
        }
        return grantedAuthoritySet;
    }
}
