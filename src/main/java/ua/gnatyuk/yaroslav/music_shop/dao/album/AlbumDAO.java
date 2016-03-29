package ua.gnatyuk.yaroslav.music_shop.dao.album;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.gnatyuk.yaroslav.music_shop.dao.CrudOperations;
import ua.gnatyuk.yaroslav.music_shop.dao.TopAlbums;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Album;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by yaroslav on 19.03.16.
 */
@Service
@Transactional
public class AlbumDAO extends CrudOperations<Album> implements TopAlbums{

    @Inject
    SessionFactory sessionFactory;

    @Override
    public Album findById(Long id) {
        Album album = (Album) sessionFactory.getCurrentSession()
                .createQuery("from Album where :id = id")
                .setParameter("id",id).uniqueResult();

        return album;
    }

    @Override
    public List<Album> getTop10AlbumsByRate() {

        List<Album> albums = sessionFactory.getCurrentSession()
                .createQuery("from Album a order by a.rating")
                .setMaxResults(10).list();

        return albums;
    }

    @Override
    public List<Album> getTop10AlbumsBySales() {

        List<Album> albums = sessionFactory.getCurrentSession()
                .createQuery("from Album a order by a.countOfSales")
                .setMaxResults(10).list();

        return albums;
    }

    @Override
    @Transactional
    public List<Album> getTheBestAlbums() {

        List<Album> albums = sessionFactory.getCurrentSession()
                .createQuery("from Album a where a.rating > 6 order by a.countOfSales")
                .setMaxResults(10).list();

        return albums;
    }
}
