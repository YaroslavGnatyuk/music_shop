package ua.gnatyuk.yaroslav.music_shop.domain.user;

import javax.persistence.*;

/**
 * Created by yaroslav on 4/26/16.
 */
@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user_id;

    @Column(name = "role",nullable = false,length = 45)
    String role;

    public UserRole() {
    }

    public UserRole(User user, String role) {
        this.user_id = user;
        this.role = new String(role);
    }

    public enum UserType{
        ROLE_ADMIN,ROLE_USER;
    }

    public void setUser_id(User user) {
        this.user_id = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
