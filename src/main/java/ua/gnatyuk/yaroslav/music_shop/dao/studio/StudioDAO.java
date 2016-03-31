package ua.gnatyuk.yaroslav.music_shop.dao.studio;

import org.springframework.stereotype.Repository;
import ua.gnatyuk.yaroslav.music_shop.dao.CrudOperations;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Studio;

import java.util.List;

/**
 * Created by yaroslav on 21.03.16.
 */
@Repository
public class StudioDAO extends CrudOperations<Studio>{

    @Override
    public List<Studio> getTop10ByRate() {
        return null;
    }

    @Override
    public List<Studio> getTop10BySales() {
        return null;
    }

    @Override
    public List<Studio> getTheBest() {
        return null;
    }

    @Override
    public Studio findById(Long id) {

        Studio studio = (Studio) sessionFactory.getCurrentSession()
                .createQuery("from Studio where :id = id")
                .setParameter("id",id).uniqueResult();

        return studio;
    }
    @Override
    public Studio findByName(String nameOfTheStudio){

        Studio studio = (Studio) sessionFactory.getCurrentSession()
                .createQuery("from Studio where :name = name")
                .setParameter("name",nameOfTheStudio).uniqueResult();

        return studio;
    }
}
