package ua.gnatyuk.yaroslav.music_shop.domain.user;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * Created by yaroslav on 5/8/16.
 * */
public class UserDto {
    @NotNull
    @Size(min = 3, max = 16)
    String lastName;

     @NotNull
     @Size(min = 3, max = 16)
    String firstName;

    @NotNull
    @Size(min = 3, max = 16)
    String username;

    @NotNull
    @Size(min = 7, max = 32)
    String password;

    @NotNull
    @Size(min = 6, max = 32)
    @Email
    String email;

    public UserDto(String firstName, String lastName, String username, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public UserDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
