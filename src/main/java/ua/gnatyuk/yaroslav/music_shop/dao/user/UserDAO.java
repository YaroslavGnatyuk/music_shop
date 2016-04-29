package ua.gnatyuk.yaroslav.music_shop.dao.user;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ua.gnatyuk.yaroslav.music_shop.dao.CrudOperations;
import ua.gnatyuk.yaroslav.music_shop.domain.user.User;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by asutp on 25.04.16.
 */
@Repository
public class UserDAO extends CrudOperations<User>{
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
    public User findByName(String userName) {
        return (User)sessionFactory.getCurrentSession()
                .createQuery("from User where :name = name")
                .setParameter("name",userName)
                .uniqueResult();
    }
}