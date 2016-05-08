package ua.gnatyuk.yaroslav.music_shop.domain.user;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by yaroslav on 5/8/16.
 */
public class UserDto {
    @NotNull
    @Size(min = 3)
    String firstName;

    @NotNull
    @Size(min = 3)
    String lastName;

    @NotNull
    @Size(min = 3)
    String username;

    @NotNull
    @Size(min = 7)
    String password;

    @NotNull
    @Size(min = 6)
    String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
