import model.Address;
import model.Studio;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import model.Category;

import java.util.List;
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
        addStudios();
        selectCategories();

        sessionFactory.close();
    }

    static void addCategories(){
        log.info("FILL CATEGORY");

        final Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        Stream.of("Pop","Rock","Hip-Hop","Elecnronic music","Classic music" ).map(Category::new).forEach(session::persist);

        session.getTransaction().commit();
        session.close();
    }

    static void addStudios(){
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        Address address1 = new Address("England","Liverpool","st.Michail Grushevskiy","12-b", 12);
        Address address2 = new Address("England","Manchester","st.Arsenicheva","1", 145);
        Address address3 = new Address("England","London","Backer str.","221-b", 1);
        Address address4 = new Address("England","Leeds","st.Koroleva","111", 31);


        Studio s1 = new Studio("Studio in Liverpool",address1);
        Studio s2 = new Studio("Studio in Manchester",address2);
        Studio s3 = new Studio("Studio in London",address3);
        Studio s4 = new Studio("Studio in Leeds",address4);


        session.persist(s1);
        session.persist(s2);
        session.persist(s3);
        session.persist(s4);

//        session.save(Address.class);
        session.getTransaction().commit();
        session.close();
    }

    static void selectCategories(){
        log.info("SELECT CATEGORIES");

        final Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        List<Studio> studios = session.createQuery("from Studio ").list();

        for (Studio s: studios) {
            Address address = s.getAddress();
            System.out.println(s.getId());
            System.out.println(s.getName());
            System.out.println(address.getCountry());
            System.out.println(address.getCity());
            System.out.println(address.getStreet());
            System.out.println(address.getHouse());
            System.out.println(address.getFlat());

        }

        session.getTransaction().commit();
        session.close();
    }
}
