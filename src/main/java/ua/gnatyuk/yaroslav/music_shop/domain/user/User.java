package ua.gnatyuk.yaroslav.music_shop.domain.user;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yaroslav on 4/2/16.
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToMany(mappedBy = "user_id", fetch = FetchType.LAZY)
    Set<UserRole> role = new HashSet<>(0);

    @Column(name = "firstName")
    String firstName;

    @Column(name = "lastName")
    String lastName;

    @Column(name = "username")
    String username;

    @Column(name ="pass")
    String password;

    @Column(name = "email")
    String email;

    @Column(name = "enable")
    Boolean enable;

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

    public void addRole(UserRole userRole){
        role.add(userRole);
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
}
