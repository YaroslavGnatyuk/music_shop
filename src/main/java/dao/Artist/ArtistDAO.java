package dao.Artist;

import dao.CrudOperations;
import dao.TopArtists;
import domain.musicrecord.Artist;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by yaroslav on 21.03.16.
 */
public class ArtistDAO extends CrudOperations<Artist> implements TopArtists {

    @Override
    public Artist findById(int id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        Artist artist = (Artist) session.createQuery("from Artist e where e.id = id").uniqueResult();

        session.getTransaction().commit();
        session.close();

        return artist;
    }

    @Override
    public List<Artist> getTop10ArtistsByRating() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        List<Artist> artists = session.createQuery("from Artist a order by a.rating").setMaxResults(10).list();

        session.getTransaction().commit();
        session.close();
        return artists;
    }

    @Override
    public List<Artist> getTop10ArtistsBySales() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        List<Artist> artists = session.createQuery("from Artist a order by a.countOfSales").setMaxResults(10).list();

        session.getTransaction().commit();
        session.close();
        return artists;
    }

    @Override
    public List<Artist> getTheBestArtists() {
        return null;
    }
}

