package ua.gnatyuk.yaroslav.music_shop.dao.Studio;

import ua.gnatyuk.yaroslav.music_shop.dao.CrudOperations;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Studio;
import org.hibernate.Session;

/**
 * Created by yaroslav on 21.03.16.
 */
public class StudioDAO extends CrudOperations<Studio>{

    @Override
    public Studio findById(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        Studio studio = (Studio) session.createQuery("from Studio e where :id = id").setParameter("id",id).uniqueResult();
        session.getTransaction().commit();
        session.close();

        return studio;
    }
}
