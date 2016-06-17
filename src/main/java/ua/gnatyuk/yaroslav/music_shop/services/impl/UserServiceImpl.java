package ua.gnatyuk.yaroslav.music_shop.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.gnatyuk.yaroslav.music_shop.dao.DaoPersist;
import ua.gnatyuk.yaroslav.music_shop.dao.user.NewUser;
import ua.gnatyuk.yaroslav.music_shop.domain.user.User;
import ua.gnatyuk.yaroslav.music_shop.services.UserService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by asutp on 12.05.16.
 */
@Service
public class UserServiceImpl implements UserService {
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
        return newUser.isExistEmail(email);
    }

    @Transactional
    @Override
    public boolean existThisUsername(String username) {
        return daoUser.findByName(username) == null ? false : true;
    }

    @Transactional
    @Override
    public void createNewUser(User user) {
        newUser.createNewUser(user);
    }

    @Transactional
    @Override
    public User findUserById(Long id) {
       return daoUser.findById(id);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        daoUser.update(user);
    }

    @Transactional
    public void deleteRolesById(Long id) {
        newUser.deleteAllRolesById(id);
    }

    @Transactional
    @Override
    public User addRolesById(Long id, List roles) {
        this.deleteRolesById(id);
        return newUser.addRolesById(id,roles);
    }
    @Transactional
    @Override
    public void deleteUser(User user) {
        daoUser.delete(user);
    }
}
