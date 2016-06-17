package ua.gnatyuk.yaroslav.music_shop.dao.user;

import org.hibernate.SessionFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.gnatyuk.yaroslav.music_shop.dao.CrudOperations;
import ua.gnatyuk.yaroslav.music_shop.domain.user.User;
import ua.gnatyuk.yaroslav.music_shop.domain.user.UserRole;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by asutp on 25.04.16.
 */
@Repository
public class UserDAO extends CrudOperations<User> implements NewUser {
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
        return (User)sessionFactory
                .getCurrentSession()
                .createQuery("FROM User WHERE :id = id")
                .setParameter("id",id)
                .uniqueResult();
    }

    @Override
    public User findByName(String username) {
        return (User)sessionFactory
                .getCurrentSession()
                .createQuery("from User where :name = username")
                .setParameter("name", username)
                .uniqueResult();
    }

    @Override
    public long getTotalRecords() {
        return (Long) sessionFactory
                .getCurrentSession()
                .createQuery("SELECT COUNT(*) FROM User")
                .uniqueResult();
    }

    @Override
    public List getMaterialsForOnePage(int begin, int sizeOfPart) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("FROM User")
                .setFirstResult(begin)
                .setMaxResults(sizeOfPart)
                .list();
    }

    @Override
    public boolean isExistEmail(String email) {
        User user = (User) sessionFactory
                .getCurrentSession()
                .createQuery("FROM User WHERE :email = email")
                .setParameter("email", email)
                .uniqueResult();

        return user != null;
    }

    @Transactional
    @Override
    public void createNewUser(User user) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        user.setEnable(true);
        user.setPassword(encoder.encode(user.getPassword()));
        UserRole role = new UserRole(user, UserRole.UserType.ROLE_USER.name());

        sessionFactory.getCurrentSession().persist(user);
        sessionFactory.getCurrentSession().persist(role);
    }

    @Transactional
    @Override
    public void update(User user){
        Set<UserRole> roles = user.getRole();
        roles.forEach(r->sessionFactory.getCurrentSession().merge(r));
        sessionFactory.getCurrentSession().merge(user);
    }

    @Transactional
    @Override
    public void deleteAllRolesById(Long id){
        User user = findById(id);

        Set<UserRole> role = user.getRole();
        if(!role.isEmpty()) {
            role.forEach(r -> sessionFactory.getCurrentSession().persist(r));
            role.forEach(r -> sessionFactory.getCurrentSession().delete(r));

            user.setUserRole("");

            user.getRole().clear();
            sessionFactory.getCurrentSession().persist(user);
        }else{
            System.out.println("Set is empty");
        }


    }

    @Override
    public User addRolesById(Long id, List<String> roles) {
        User user = findById(id);
        Set<UserRole> roleSet = new HashSet<>();
        roles.forEach(r->roleSet.add(new UserRole(user,r)));
        user.setRole(roleSet);

        StringBuilder sb = new StringBuilder();
        roles.forEach(r->sb.append(r));

        user.setUserRole(sb.toString());

        roleSet.forEach(r->sessionFactory.getCurrentSession().persist(r));
        sessionFactory.getCurrentSession().persist(user);

        return user;
    }
}