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
        Artist artist = (Artist) sessionFactory.getCurrentSession()
                .createQuery("from Artist where :id = id ")
                .setParameter("id",id).uniqueResult();

        return  artist;
    }

    @Override
    public Artist findByName(String nameOfArtist) {
        Artist artist = (Artist) sessionFactory.getCurrentSession()
                .createQuery("from Artist where :name = name")
                .setParameter("name",nameOfArtist).uniqueResult();

        return artist;
    }

    @Override
    public long getTotalRecords() {
        return (Long) sessionFactory.getCurrentSession().createQuery("SELECT COUNT(*) FROM Artist").uniqueResult();
    }

    @Override
    public List<Artist> getTop10ByRate() {

        List<Artist> artists = sessionFactory.getCurrentSession()
                .createQuery("from Artist a order by a.rating desc")
                .setMaxResults(10).list();

        return artists;

    }

    @Transactional
    @Override
    public List<Artist> getTop10BySales() {

        List<Artist> artists = sessionFactory.getCurrentSession()
                .createQuery("from Artist a order by a.countOfSales desc")
                .setMaxResults(10).list();

        return artists;
    }

    @Transactional
    @Override
    public List<Artist> getTheBest() {

        List<Artist> artists = sessionFactory.getCurrentSession()
                .createQuery("from Artist a where a.rating > 6 order by a.countOfSales desc")
                .setMaxResults(10).list();

        return artists;
    }

    @Transactional
    @Override
    public List<Artist> getAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Artist ").list();
    }

    @Override
    public List<Artist> getMaterialsForOnePage(int begin, int sizeOfPart) {
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

