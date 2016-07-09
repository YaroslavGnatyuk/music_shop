package ua.gnatyuk.yaroslav.music_shop.dao.article;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.gnatyuk.yaroslav.music_shop.dao.CrudOperations;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by yaroslav on 6/19/16.
 */

@Repository
public class ArticleDAO extends CrudOperations{
    @Inject
    SessionFactory sessionFactory;

    @Override
    public List getTop10ByRate() {
        return null;
    }

    @Override
    public List getTop10BySales() {
        return null;
    }

    @Override
    public List getTheBest() {
        return null;
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public Object findByName(String name) {
        return null;
    }

    @Override
    public Object findById(Long id) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Article WHERE :id=id")
                .setParameter("id",id)
                .uniqueResult();
    }

    @Override
    public long getTotalRecords() {
        return (long) sessionFactory
                .getCurrentSession()
                .createQuery("SELECT COUNT (*) FROM Article")
                .uniqueResult();
    }

    @Override
    public List getMaterialsForOnePage(int begin, int sizeOfPart) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("FROM Article")
                .setFirstResult(begin)
                .setMaxResults(sizeOfPart)
                .list();
    }
}
