package ua.gnatyuk.yaroslav.music_shop.dao.user;

import ua.gnatyuk.yaroslav.music_shop.domain.user.User;

import java.util.List;

/**
 * Created by asutp on 09.05.16.
 */
public interface NewUser {
    void createNewUser(User user);
    void deleteAllRolesById(Long id);
    User addRolesById(Long id, List<String> roles);
    boolean isExistEmail(String email);
}
