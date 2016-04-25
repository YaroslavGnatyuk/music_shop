package ua.gnatyuk.yaroslav.music_shop.application.impl;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.gnatyuk.yaroslav.music_shop.dao.DaoPersist;
import ua.gnatyuk.yaroslav.music_shop.domain.user.User;

import javax.inject.Inject;
import javax.inject.Named;

import static java.util.stream.Collectors.toSet;

/**
 * Created by asutp on 25.04.16.
 */
@Service
public class UserServ implements UserDetailsService {
    @Inject
    @Named(value = "userDAO")
    DaoPersist<User> daoUser;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = daoUser.findByName(username);

        org.springframework.security.core.userdetails.User userDetaile =
                new org.springframework.security.core.userdetails
                        .User(user.getName(),user.getPassword(),user.getRoles().stream().map(r->new SimpleGrantedAuthority(r.name())).collect(toSet()));


        return userDetaile;
    }

    @Transactional
    public void createNewUser(User user){
        daoUser.create(user);
    }
}
