package ua.gnatyuk.yaroslav.music_shop.dao.studio;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.gnatyuk.yaroslav.music_shop.dao.CrudOperations;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Studio;

import javax.inject.Inject;

/**
 * Created by yaroslav on 21.03.16.
 */
@Service
@Transactional
public class StudioDAO extends CrudOperations<Studio>{

    @Inject
    private SessionFactory sessionFactory;

    @Override
    public Studio findById(Long id) {

        Studio studio = (Studio) sessionFactory.getCurrentSession()
                .createQuery("from Studio e where :id = id")
                .setParameter("id",id).uniqueResult();

        return studio;
    }
}
