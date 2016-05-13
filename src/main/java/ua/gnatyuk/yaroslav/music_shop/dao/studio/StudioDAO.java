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
    public List getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Studio")
                .list();
    }

    @Override
    public Studio findById(Long id) {
      return (Studio) sessionFactory.getCurrentSession()
                .createQuery("from Studio where :id = id")
                .setParameter("id",id).uniqueResult();
    }
    @Override
    public Studio findByName(String nameOfTheStudio){
        return (Studio) sessionFactory.getCurrentSession()
                .createQuery("from Studio where :name = name")
                .setParameter("name",nameOfTheStudio).uniqueResult();
    }

    @Override
    public long getTotalRecords() {
        return (Long) sessionFactory
                .getCurrentSession()
                .createQuery("SELECT COUNT(*) FROM Studio")
                .uniqueResult();
    }

    @Override
    public List getMaterialsForOnePage(int begin, int sizeOfPart) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Studio")
                .setFirstResult(begin)
                .setMaxResults(sizeOfPart)
                .list();
    }

    @Override
    public boolean existThisEmail(String email) {
        return false;
    }
}
