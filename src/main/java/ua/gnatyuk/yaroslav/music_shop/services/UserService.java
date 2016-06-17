package ua.gnatyuk.yaroslav.music_shop.services;

import ua.gnatyuk.yaroslav.music_shop.domain.user.User;

import java.util.List;

/**
 * Created by asutp on 30.04.16.
 */
public interface UserService {
    long getCountAllUsers();

    boolean existThisEmail(String email);
    boolean existThisUsername(String username);
    void createNewUser(User user);
    void updateUser(User user);
    User findUserById(Long id);
    User addRolesById(Long id, List roles);
    void deleteUser(User user);
}
