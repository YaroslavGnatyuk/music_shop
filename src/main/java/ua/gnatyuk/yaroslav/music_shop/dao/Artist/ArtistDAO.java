package ua.gnatyuk.yaroslav.music_shop.dao.Artist;

import ua.gnatyuk.yaroslav.music_shop.dao.CrudOperations;
import ua.gnatyuk.yaroslav.music_shop.dao.TopArtists;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Artist;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by yaroslav on 21.03.16.
 */
public class ArtistDAO extends CrudOperations<Artist> implements TopArtists {

    @Override
    public Artist findById(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        Artist artist = (Artist) session.createQuery("from Artist where :id = id ").setParameter("id",id).uniqueResult();

        session.getTransaction().commit();
        session.close();

        return artist;
    }

    @Override
    public List<Artist> getTop10ArtistsByRating() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        List<Artist> artists = session.createQuery("from Artist a order by a.rating desc").setMaxResults(10).list();

        session.getTransaction().commit();
        session.close();
        return artists;
    }

    @Override
    public List<Artist> getTop10ArtistsBySales() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        List<Artist> artists = session.createQuery("from Artist a order by a.countOfSales desc").setMaxResults(10).list();

        session.getTransaction().commit();
        session.close();
        return artists;
    }

    @Override
    public List<Artist> getTheBestArtists() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        List<Artist> artists = session.createQuery("from Artist a where a.rating > 6 order by a.countOfSales desc").setMaxResults(10).list();

        session.getTransaction().commit();
        session.close();
        return artists;
    }
}

