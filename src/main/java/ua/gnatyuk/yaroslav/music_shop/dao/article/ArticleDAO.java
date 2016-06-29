package ua.gnatyuk.yaroslav.music_shop.dao.article;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
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
        return null;
    }

    @Override
    public long getTotalRecords() {
        return 0;
    }

    @Override
    public List getMaterialsForOnePage(int begin, int sizeOfPart) {
        return null;
    }
}
