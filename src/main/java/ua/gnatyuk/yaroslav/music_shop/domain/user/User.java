package ua.gnatyuk.yaroslav.music_shop.domain.user;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "role")
    Set<UserRole> role = new HashSet<>(0);

    @Column(name = "name")
    String name;

    @Column(name ="pass")
    String password;

    @Column(name = "email")
    String email;

    @Column(name = "enable")
    Boolean enable;

    public User() {
    }

    public User(UserRole role, String name, String password, String email, Boolean enable) {
        this.role.add(role);
        this.name = name;
        this.password = password;
        this.email = email;
        this.enable = enable;
    }

    public Set<UserRole> getRole() {
        return role;
    }

    public void setRole(Set<UserRole> role) {
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
