package dao.Artist;

import dao.CrudOperations;
import domain.musicrecord.Artist;
import org.hibernate.Session;

/**
 * Created by yaroslav on 21.03.16.
 */
public class ArtistCRUDImpl extends CrudOperations<Artist> {

    @Override
    public Artist findById(int id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        Artist artist = (Artist) session.createQuery("from Artist e where e.id = id").uniqueResult();

        session.getTransaction().commit();
        session.close();

        return artist;
    }
}

