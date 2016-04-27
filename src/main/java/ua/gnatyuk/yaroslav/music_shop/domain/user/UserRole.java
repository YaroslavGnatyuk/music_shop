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
    @JoinColumn(name = "user_id",nullable = true)
    User user;

    @Column(name = "role",nullable = false,length = 45)
    String role;

    public UserRole() {
    }

    public UserRole(User user, String role) {
        System.out.println("!!!!!" + role + "!!!!");

        this.user = user;
        this.role = role;
    }

    public enum UserType{
        ROLE_ADMIN,ROLE_USER;

        public static String setRoleAdmin(){
            return UserType.ROLE_ADMIN.name();
        }

        public static String setRoleUser(){
            return UserType.ROLE_USER.name();
        }
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
