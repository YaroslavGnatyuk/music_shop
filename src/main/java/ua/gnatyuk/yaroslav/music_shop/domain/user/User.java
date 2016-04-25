package ua.gnatyuk.yaroslav.music_shop.domain.user;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaroslav on 4/2/16.
 */
@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated
    @Column(name = "ROLE")
    Role role;

    @Column(name = "NAME")
    String name;

    @Column(name ="PASS")
    String password;

    @Column(name = "EMAIL")
    String email;

    @Column(name = "ENABLE")
    Boolean enable;

    public enum Role {
        ROLE_USER, ROLE_ADMIN;

    }

    public User() {
    }

    public User(Role role, String name, String password, String email, Boolean enable) {
        this.role = role;
        this.name = name;
        this.password = password;
        this.email = email;
        this.enable = enable;
    }

    public Role getRole() {
        return role;
    }

    public List<Role> getRoles() {
        List<Role> roles = new ArrayList<>();
        roles.add(this.role);
        return roles;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
