package Dao.Studio;

import Dao.CrudOperations;
import domain.musicrecord.Studio;
import org.hibernate.Session;

/**
 * Created by yaroslav on 21.03.16.
 */
public class StudioCRUDImpl extends CrudOperations<Studio>{

    @Override
    public Studio findById(int id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        Studio studio = (Studio) session.createQuery("from Studio e where e.id = id").uniqueResult();

        session.getTransaction().commit();
        session.close();

        sessionFactory.close();

        return studio;
    }
}
