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
    public Album findById(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        Album album = (Album) session.createQuery("from Album where :id = id").setParameter("id",id).uniqueResult();

        session.getTransaction().commit();
        session.close();

        return album;
    }


    @Override
    public List<Album> getTop10AlbumsByRate() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        List<Album> albums = session.createQuery("from Album a order by a.rating").setMaxResults(10).list();

        session.getTransaction().commit();
        session.close();

        return albums;
    }

    @Override
    public List<Album> getTop10AlbumsBySales() {

        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        List<Album> albums = session.createQuery("from Album a order by a.countOfSales").setMaxResults(10).list();

        session.getTransaction().commit();
        session.close();

        return albums;
    }

    @Override
    public List<Album> getTheBestAlbums() {

        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        List<Album> albums = session.createQuery("from Album a where a.rating > 6 order by a.countOfSales").setMaxResults(10).list();

        session.getTransaction().commit();
        session.close();

        return albums;
    }
}
