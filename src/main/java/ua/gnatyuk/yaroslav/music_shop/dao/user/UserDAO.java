package ua.gnatyuk.yaroslav.music_shop.dao.user;

import org.hibernate.SessionFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.gnatyuk.yaroslav.music_shop.dao.CrudOperations;
import ua.gnatyuk.yaroslav.music_shop.domain.user.User;
import ua.gnatyuk.yaroslav.music_shop.domain.user.UserDto;
import ua.gnatyuk.yaroslav.music_shop.domain.user.UserRole;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by asutp on 25.04.16.
 */
@Repository
public class UserDAO extends CrudOperations<User> implements CreateUserByUserDto{
    @Inject
    SessionFactory sessionFactory;

    @Override
    public List<User> getTop10ByRate() {
        return null;
    }

    @Override
    public List<User> getTop10BySales() {
        return null;
    }

    @Override
    public List<User> getTheBest() {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User findByName(String username) {
        return (User)sessionFactory.getCurrentSession()
                .createQuery("from User where :name = username")
                .setParameter("name", username)
                .uniqueResult();
    }

    @Override
    public long getTotalRecords() {
        return (Long) sessionFactory.getCurrentSession().createQuery("SELECT COUNT(*) FROM User").uniqueResult();
    }

    @Override
    public List<User> getMaterialsForOnePage(int begin, int sizeOfPart) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM User")
                .setFirstResult(begin)
                .setMaxResults(sizeOfPart)
                .list();
    }

    @Override
    public boolean existThisEmail(String email) {
        User user = (User) sessionFactory.getCurrentSession()
                .createQuery("FROM User WHERE :email = email")
                .setParameter("email", email).uniqueResult();

        return (user == null) ? false : true;
    }

    @Transactional
    @Override
    public void createUserByUserDto(UserDto userDto) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        User newUser = new User();

        newUser.setFirstName(userDto.getFirstName());
        newUser.setLastName(userDto.getLastName());
        newUser.setEmail(userDto.getEmail());
        newUser.setEnable(false);
        newUser.setUsername(userDto.getUsername());

        UserRole role = new UserRole();
        role.setRole(UserRole.UserType.ROLE_USER.name());
        newUser.addRole(role);

        newUser.setPassword(encoder.encode(userDto.getPassword()));

        sessionFactory.getCurrentSession().persist(newUser);
    }
}
