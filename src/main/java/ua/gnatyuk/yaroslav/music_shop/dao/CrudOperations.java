package ua.gnatyuk.yaroslav.music_shop.dao;

import org.hibernate.SessionFactory;

import javax.inject.Inject;

/**
 * Created by yaroslav on 22.03.16.
 */
public abstract class CrudOperations<T> implements DaoPersist<T> {
    @Inject
    protected SessionFactory sessionFactory;


    public void create(T obj) {
        sessionFactory.getCurrentSession().persist(obj);
    }

    public void update(T obj) {
        sessionFactory.getCurrentSession().merge(obj);
    }

    public void delete(T obj) {
        sessionFactory.getCurrentSession().delete(obj);
    }

}
