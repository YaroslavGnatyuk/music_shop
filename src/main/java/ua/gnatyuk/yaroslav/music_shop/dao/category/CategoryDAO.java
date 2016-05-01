package ua.gnatyuk.yaroslav.music_shop.dao.category;

import org.springframework.stereotype.Repository;
import ua.gnatyuk.yaroslav.music_shop.dao.CrudOperations;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Category;

import java.util.List;

/**
 * Created by yaroslav on 4/11/16.
 */
@Repository
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
    public List<Category> getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Category")
                .list();
    }

    @Override
    public Category findById(Long id) {
        Category category = (Category) sessionFactory
                .getCurrentSession()
                .createQuery("from Category where :id = id")
                .setParameter("id",id).uniqueResult();
        return category;
    }

    @Override
    public Category findByName(String nameOfTheStudio) {

        Category category = (Category) sessionFactory
                .getCurrentSession()
                .createQuery("from Category where :name = name")
                .setParameter("name",nameOfTheStudio).uniqueResult();
        return category;
    }

    @Override
    public long getTotalRecords() {
        return (Long) sessionFactory.getCurrentSession().createQuery("SELECT COUNT(*) FROM Category").uniqueResult();
    }
}
