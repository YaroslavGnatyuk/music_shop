package ua.gnatyuk.yaroslav.music_shop.services.impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.gnatyuk.yaroslav.music_shop.dao.user.CreateUserByUserDto;
import ua.gnatyuk.yaroslav.music_shop.domain.user.UserDto;
import ua.gnatyuk.yaroslav.music_shop.dao.DaoPersist;
import ua.gnatyuk.yaroslav.music_shop.domain.user.User;
import ua.gnatyuk.yaroslav.music_shop.domain.user.UserRole;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by asutp on 25.04.16.
 */

@Service
public class LoginServiceImpl implements UserDetailsService, LoginServiceImpl {
    @Inject
    @Named(value = "userDAO")
    DaoPersist<User> daoUser;

    @Inject
    CreateUserByUserDto newUser;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = daoUser.findByName(username);
        Set<UserRole> userRoles = user.getRole();

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (UserRole role : userRoles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
        }

        List<GrantedAuthority> authorities = new ArrayList<>(grantedAuthorities);

        org.springframework.security.core.userdetails.User newUser =
                new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                user.getEnable(), true, true, true, authorities);

        return newUser;
    }

    @Transactional
    @Override
    public long getCountAllUsers() {
        return daoUser.getTotalRecords();
    }

    @Transactional
    @Override
    public boolean existThisEmail(String email) {
        return daoUser.existThisEmail(email);
    }

    @Transactional
    @Override
    public boolean existThisUsername(String username) {
        return daoUser.findByName(username) == null ? false : true;
    }

    @Transactional
    @Override
    public void createNewUser(UserDto userDto) {
        newUser.createNewUser(userDto);
    }
}
