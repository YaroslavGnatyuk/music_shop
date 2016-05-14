package ua.gnatyuk.yaroslav.music_shop.dao.category;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import ua.gnatyuk.yaroslav.music_shop.dao.CrudOperations;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Category;

import java.util.List;

/**
 * Created by yaroslav on 4/11/16.
 */
@Repository
@Lazy(value = true)
public class CategoryDAO extends CrudOperations<Category>{
    @Override
    public List<Category> getTop10ByRate() {
        return null;
    }

    @Override
    public List<Category> getTop10BySales() {
        return null;
    }

    @Override
    public List<Category> getTheBest() {
        return null;
    }

    @Override
    public List getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Category")
                .list();
    }

    @Override
    public Category findById(Long id) {
        return (Category) sessionFactory
                .getCurrentSession()
                .createQuery("from Category where :id = id")
                .setParameter("id",id).uniqueResult();
    }

    @Override
    public Category findByName(String nameOfTheStudio) {
        return (Category) sessionFactory
                .getCurrentSession()
                .createQuery("from Category where :name = name")
                .setParameter("name",nameOfTheStudio).uniqueResult();
    }

    @Override
    public long getTotalRecords() {
        return (Long) sessionFactory
                .getCurrentSession()
                .createQuery("SELECT COUNT(*) FROM Category")
                .uniqueResult();
    }

    @Override
    public List getMaterialsForOnePage(int begin, int sizeOfPart) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("FROM Category")
                .setFirstResult(begin)
                .setMaxResults(sizeOfPart)
                .list();
    }

    @Override
    public boolean existThisEmail(String email) {
        return false;
    }
}
