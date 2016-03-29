package ua.gnatyuk.yaroslav.music_shop.dao.artist;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.gnatyuk.yaroslav.music_shop.dao.CrudOperations;
import ua.gnatyuk.yaroslav.music_shop.dao.TopArtists;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Artist;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by yaroslav on 21.03.16.
 */
@Service
@Transactional
public class ArtistDAO extends CrudOperations<Artist> implements TopArtists {

    @Inject
    SessionFactory sessionFactory;

    @Override
    public Artist findById(Long id) {
        sessionFactory.getCurrentSession()
                .createQuery("from Artist where :id = id ")
                .setParameter("id",id).uniqueResult();
        return new Artist();
    }

    @Override
    public List<Artist> getTop10ArtistsByRating() {

        List<Artist> artists = sessionFactory.getCurrentSession()
                .createQuery("from Artist a order by a.rating desc")
                .setMaxResults(10).list();

        return artists;

    }

    @Override
    public List<Artist> getTop10ArtistsBySales() {

        List<Artist> artists = sessionFactory.getCurrentSession()
                .createQuery("from Artist a order by a.countOfSales desc")
                .setMaxResults(10).list();

        return artists;
    }

    @Override
    public List<Artist> getTheBestArtists() {

        List<Artist> artists = sessionFactory.getCurrentSession()
                .createQuery("from Artist a where a.rating > 6 order by a.countOfSales desc")
                .setMaxResults(10).list();

        return artists;
    }
}

