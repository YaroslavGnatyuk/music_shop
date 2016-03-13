import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import model.Category;

import java.util.stream.Stream;

/**
 * Created by yaroslav on 13.03.16.
 */
public class TestMusicShop {

    private static final Logger log = LoggerFactory.getLogger(TestMusicShop.class);
    static SessionFactory sessionFactory;

    public static void main(String[] args) {
        sessionFactory = new Configuration().configure().buildSessionFactory();

        addCategories();

        sessionFactory.close();
    }

    static void addCategories(){
        log.info("FILL CATEGORY");

        final Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        Stream.of("Pop","Rock").map(Category::new).forEach(session::persist);

        session.getTransaction().commit();
        session.close();
    }
}
