package ua.gnatyuk.yaroslav.music_shop.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.gnatyuk.yaroslav.music_shop.dao.DaoPersist;
import ua.gnatyuk.yaroslav.music_shop.dao.user.NewUser;
import ua.gnatyuk.yaroslav.music_shop.domain.user.User;
import ua.gnatyuk.yaroslav.music_shop.domain.user.UserDto;
import ua.gnatyuk.yaroslav.music_shop.services.RegistrationService;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by asutp on 12.05.16.
 */
@Service
public class RegistrationServiceImpl implements RegistrationService{
    @Inject
    @Named(value = "userDAO")
    DaoPersist<User> daoUser;

    @Inject
    NewUser newUser;

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
