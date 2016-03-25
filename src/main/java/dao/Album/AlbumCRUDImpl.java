package dao.Album;

import dao.CrudOperations;
import domain.musicrecord.Album;
import org.hibernate.Session;

/**
 * Created by yaroslav on 19.03.16.
 */
public class AlbumCRUDImpl extends CrudOperations<Album>{

    @Override
    public Album findById(int id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        Album album = (Album) session.createQuery("from Album where Album.id = id").uniqueResult();

        session.getTransaction().commit();
        session.close();

        return album;
    }


}
