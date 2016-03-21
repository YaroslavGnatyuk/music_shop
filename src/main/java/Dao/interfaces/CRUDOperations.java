package Dao.interfaces;

import domain.musicrecord.Album;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by yaroslav on 19.03.16.
 */
public interface CRUDOperations<T> {
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    void createOrUpdate(T obj);
    T findById(int id);
    void delete(T obj);
}
