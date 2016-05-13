package ua.gnatyuk.yaroslav.music_shop.dao.artist;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.gnatyuk.yaroslav.music_shop.dao.CrudOperations;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Artist;

import java.util.List;

/**
 * Created by yaroslav on 21.03.16.
 */

@Repository
public class ArtistDAO extends CrudOperations<Artist> {

    @Override
    public Artist findById(Long id) {
        return (Artist) sessionFactory.getCurrentSession()
                .createQuery("from Artist where :id = id ")
                .setParameter("id",id).uniqueResult();
    }

    @Override
    public Artist findByName(String nameOfArtist) {
        return (Artist) sessionFactory.getCurrentSession()
                .createQuery("from Artist where :name = name")
                .setParameter("name",nameOfArtist).uniqueResult();
    }

    @Override
    public long getTotalRecords() {
        return (Long) sessionFactory.getCurrentSession().createQuery("SELECT COUNT(*) FROM Artist").uniqueResult();
    }

    @Override
    public List getTop10ByRate() {
        return  sessionFactory.getCurrentSession()
                .createQuery("from Artist a order by a.rating desc")
                .setMaxResults(10).list();
    }

    @Transactional
    @Override
    public List getTop10BySales() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Artist a order by a.countOfSales desc")
                .setMaxResults(10).list();
    }

    @Transactional
    @Override
    public List getTheBest() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Artist a where a.rating > 6 order by a.countOfSales desc")
                .setMaxResults(10).list();
    }

    @Transactional
    @Override
    public List getAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Artist ").list();
    }

    @Override
    public List getMaterialsForOnePage(int begin, int sizeOfPart) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Artist ")
                .setFirstResult(begin)
                .setMaxResults(sizeOfPart)
                .list();
    }

    @Override
    public boolean existThisEmail(String email) {
        return false;
    }
}