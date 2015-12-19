package by.bsu.fpmi.kolyadkodarya.services.impl;

import by.bsu.fpmi.kolyadkodarya.model.User;
import by.bsu.fpmi.kolyadkodarya.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import by.bsu.fpmi.kolyadkodarya.services.UserService;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 26.10.2015.
 */
@Service ("userDetailsService")
public class CustomUserDetailServiceImpl implements UserDetailsService{

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.readUserByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User not found!");
        }

        Set<GrantedAuthority> authorities = buildUserAuthorities(user.getUserRolesSet());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    private Set<GrantedAuthority> buildUserAuthorities(Set<UserRole> userRoles) {
        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<GrantedAuthority>();
        for (UserRole userRole : userRoles){
            grantedAuthoritySet.add(new SimpleGrantedAuthority(userRole.getRole()));
        }
        return  grantedAuthoritySet;
    }
}
