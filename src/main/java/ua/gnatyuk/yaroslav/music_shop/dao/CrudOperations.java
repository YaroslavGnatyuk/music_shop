package ua.gnatyuk.yaroslav.music_shop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by yaroslav on 22.03.16.
 */
public abstract class CrudOperations<T>{
    protected static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void createOrUpdate(T obj){
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        session.persist(obj);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public abstract T findById(Long id);

    public void delete(T obj){
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

//        session.update(obj);
        session.delete(obj);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
