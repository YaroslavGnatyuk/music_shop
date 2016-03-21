package Dao.Album;

import Dao.interfaces.CRUDOperations;
import domain.musicrecord.Album;
import org.hibernate.Session;

/**
 * Created by yaroslav on 19.03.16.
 */
public class AlbumCRUDImpl implements CRUDOperations<Album> {

    @Override
    public void createOrUpdate(Album obj) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        session.persist(obj);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Album findById(int id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        Album album = (Album) session.createQuery("from Album where Album.id = id").uniqueResult();

        session.getTransaction().commit();
        session.close();

        return album;
    }

    @Override
    public void delete(Album obj) {
        Session session = sessionFactory.openSession();
        session.getTransaction();

        session.persist(obj);
        session.delete(obj);

        session.getTransaction().commit();
        session.close();
    }
}
