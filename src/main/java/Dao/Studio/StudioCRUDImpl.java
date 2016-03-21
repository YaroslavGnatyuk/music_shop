package Dao.Studio;

import Dao.interfaces.CRUDOperations;
import domain.musicrecord.Album;
import domain.musicrecord.Studio;
import org.hibernate.Session;

/**
 * Created by yaroslav on 21.03.16.
 */
public class StudioCRUDImpl implements CRUDOperations<Studio>{
    @Override
    public void createOrUpdate(Studio obj) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        session.persist(obj);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Studio findById(int id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        Studio studio = (Studio) session.createQuery("from Studio where Studio.id = id").uniqueResult();

        session.getTransaction().commit();
        session.close();

        return studio;
    }

    @Override
    public void delete(Studio obj) {
        Session session = sessionFactory.openSession();
        session.getTransaction();

        session.persist(obj);
        session.delete(obj);

        session.getTransaction().commit();
        session.close();
    }
}
