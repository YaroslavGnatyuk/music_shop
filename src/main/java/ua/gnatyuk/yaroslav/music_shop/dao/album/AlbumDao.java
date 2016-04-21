package ua.gnatyuk.yaroslav.music_shop.dao.album;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.gnatyuk.yaroslav.music_shop.dao.CrudOperations;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Album;

import java.util.List;

/**
 * Created by yaroslav on 19.03.16.
 */
@Repository
public class AlbumDao extends CrudOperations<Album> {

    @Transactional
    @Override
    public Album findById(Long id) {
        Album album = (Album) sessionFactory.getCurrentSession()
                .createQuery("from Album where :id = id")
                .setParameter("id",id).uniqueResult();
        return album;
    }
    @Transactional
    @Override
    public Album findByName(String nameOfTheAlbum) {
        Album album = (Album) sessionFactory.getCurrentSession()
                .createQuery("from Album where :name = name")
                .setParameter("name",nameOfTheAlbum).uniqueResult();
        return album;
    }

    @Transactional
    @Override
    public List<Album> getTop10ByRate() {
        List<Album> albums = sessionFactory.getCurrentSession()
                .createQuery("from Album a order by a.rating")
                .setMaxResults(10).list();
        return albums;
    }

    @Transactional
    @Override
    public List<Album> getTop10BySales() {
        List<Album> albums = sessionFactory.getCurrentSession()
                .createQuery("from Album a order by a.countOfSales")
                .setMaxResults(10).list();
        return albums;
    }

    @Override
    @Transactional
    public List<Album> getTheBest() {
        List<Album> albums = sessionFactory.getCurrentSession()
                .createQuery("from Album a where a.rating > 6 order by a.countOfSales")
                .setMaxResults(10).list();
        return albums;
    }

    @Transactional
    @Override
    public List<Album> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Album").list();
    }
}
