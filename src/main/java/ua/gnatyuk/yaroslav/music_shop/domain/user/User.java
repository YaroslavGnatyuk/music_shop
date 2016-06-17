package ua.gnatyuk.yaroslav.music_shop.domain.user;

import org.hibernate.validator.constraints.Email;
import ua.gnatyuk.yaroslav.music_shop.dao.user.NewUser;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

/**
 * Created by yaroslav on 4/2/16.
 */
@Entity
@Table(name = "user")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user_id", fetch = FetchType.EAGER)
    private Set<UserRole> role = new HashSet<>(5);

    @NotNull
    @Size(min = 3, max = 16)
    @Column(name = "firstName")
    private String firstName;

    @NotNull
    @Size(min = 3, max = 16)
    @Column(name = "lastName")
    private String lastName;

    @NotNull
    @Size(min = 3, max = 16)
    @Column(name = "username")
    private String username;

    @NotNull
    @Size(min = 7)
    @Column(name ="pass")
    private String password;

    @NotNull
    @Size(min = 6, max = 32)
    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "enable")
    private Boolean enable;

    @Transient
    private String userRole;

    public User() {
    }

    public User(String firstName, String password, String email, Boolean enable) {
        this.firstName = firstName;
        this.password = password;
        this.email = email;
        this.enable = enable;
    }

    public User(String firstName, String lastName, String username, String password, String email, Boolean enable) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.enable = enable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<UserRole> getRole() {
        return role;
    }

    public String getUserRole(){
        StringBuilder buildStringRoles = new StringBuilder();
        Iterator iterator = role.iterator();

        while(iterator.hasNext()) {
            UserRole userRole = (UserRole) iterator.next();
            buildStringRoles.append(userRole.getRole() + " ");
        }

        return new String(buildStringRoles);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", enable=" + enable +
                ", userRole='" + userRole + '\'' +
                '}';
    }

    public void setRole(Set<UserRole> role) {
        this.role = role;
    }

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

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public void setUserRole() {
        this.userRole = getUserRole();
    }

}
