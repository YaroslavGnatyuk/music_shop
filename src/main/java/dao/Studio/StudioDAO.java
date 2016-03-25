package dao.Studio;

import dao.CrudOperations;
import domain.musicrecord.Studio;
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
