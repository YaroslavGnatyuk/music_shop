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
       return (Album) sessionFactory.getCurrentSession()
                .createQuery("from Album where :id = id")
                .setParameter("id",id).uniqueResult();
    }

    @Transactional
    @Override
    public Album findByName(String nameOfTheAlbum) {
        return (Album) sessionFactory.getCurrentSession()
                .createQuery("from Album where :name = name")
                .setParameter("name",nameOfTheAlbum).uniqueResult();
    }

    @Transactional
    @Override
    public List getTop10ByRate() {
        return   sessionFactory.getCurrentSession()
                .createQuery("from Album a order by a.rating")
                .setMaxResults(10).list();
    }

    @Transactional
    @Override
    public List getTop10BySales() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Album a order by a.countOfSales")
                .setMaxResults(10).list();
    }

    @Override
    @Transactional
    public List getTheBest() {
        return  sessionFactory.getCurrentSession()
                .createQuery("from Album a where a.rating > 6 order by a.countOfSales")
                .setMaxResults(10).list();
    }

    @Transactional
    @Override
    public List getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Album").list();
    }


    @Override
    public long getTotalRecords() {
        return (Long) sessionFactory.getCurrentSession().createQuery("SELECT COUNT(*) FROM Album").uniqueResult();
    }

    @Override
    public List getMaterialsForOnePage(int begin, int sizeOfPart) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Album ")
                .setFirstResult(begin)
                .setMaxResults(sizeOfPart)
                .list();
    }

    @Override
    public boolean existThisEmail(String email) {
        return false;
    }
}
