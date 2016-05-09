package ua.gnatyuk.yaroslav.music_shop.services;

import ua.gnatyuk.yaroslav.music_shop.domain.user.UserDto;

/**
 * Created by asutp on 30.04.16.
 */
public interface UserService {
    long getCountAllUsers();
    boolean isExistThisEmail(String email);
    boolean isExistThisUsername(String username);
    void createNewUser(UserDto userDto);
}
