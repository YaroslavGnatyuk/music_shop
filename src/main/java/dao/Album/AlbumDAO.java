package dao.Album;

import dao.CrudOperations;
import dao.TopAlbums;
import domain.musicrecord.Album;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by yaroslav on 19.03.16.
 */
public class AlbumDAO extends CrudOperations<Album> implements TopAlbums{

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
    public List<Album> getTop10AlbumsByRate() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        List<Album> topAlbumsByRating = (List<Album>) session.createQuery("from Album a where a.rating > 5 ");

        return topAlbumsByRating;
    }

    @Override
    public List<Album> getTop10AlbumsBySales() {
        return null;
    }

    @Override
    public List<Album> getTheBestAlbums() {
        return null;
    }
}
