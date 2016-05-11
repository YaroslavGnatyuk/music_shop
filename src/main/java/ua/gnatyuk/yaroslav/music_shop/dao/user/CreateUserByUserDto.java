package ua.gnatyuk.yaroslav.music_shop.dao.user;

import ua.gnatyuk.yaroslav.music_shop.domain.user.User;
import ua.gnatyuk.yaroslav.music_shop.domain.user.UserDto;

/**
 * Created by asutp on 09.05.16.
 */
public interface CreateUserByUserDto {
    void createNewUser(UserDto userDto);
}
