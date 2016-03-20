import model.*;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.source.spi.HibernateTypeSource;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.schema.internal.HibernateSchemaManagementTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
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

        addStudios();
        selectCategories();

        sessionFactory.close();
    }

    static void addStudios(){
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        Stream.of("Pop","Rock","Hip-Hop","Elecnronic music","Classic music" ).map(Category::new).forEach(session::persist);

        Address oeAddress = new Address("Ukraine","Kiev","Michail Grushevskiy str.","12-b", 12);
        Address mushroomAddress = new Address("England","Manchester","Arsenicheva str.","1", 145);
        Address krushAddress= new Address("Japan","Osaka","Backer str.","221-b", 1);
        Address akiroAddress = new Address("Japan","Tokio","Koroleva str.","111", 31);
        Address wuTangAddress = new Address("USA","Brookln","some street","21",00);


        Studio studioInUkraine = new Studio("Студия Океана Эльзы",oeAddress);
        Studio studioInEngland = new Studio("Infected Mushroom's studio",mushroomAddress);
        Studio studioInJapan2= new Studio("Dj Krush's studio",krushAddress);
        Studio studioInJapan = new Studio("Akiros studio",akiroAddress);
        Studio studioInNY = new Studio("Wu-Tang clans studio",wuTangAddress);

        List<Category> category = session.createQuery("from Category").list();

        Artist wuTang = new Artist("Wu-tang clan",wuTangAddress,LocalDate.of(1992,10,19),null,"wutang@gmail.com",category.get(2),studioInNY);
        Artist oElzi = new Artist("Океан Эльзы",oeAddress,LocalDate.of(1994,1,1),null,"oe@gmail.com",category.get(1),studioInUkraine);
        Artist djKrush = new Artist("Dj Krush",krushAddress,LocalDate.of(1962,7,27),null,"krush@gmail.com",category.get(3),studioInJapan2);
        Artist infectedMushroom = new Artist("Infected Mushroom",mushroomAddress,LocalDate.of(1996,1,1),null,"mushroom@gmail.com",category.get(3),studioInEngland);
        Artist akiraYamaoka = new Artist("Akira Yamaoka",akiroAddress,LocalDate.of(1968,2,6),null,"silent@gmail.com",category.get(3),studioInJapan);

        Album wuAlbum1 = new Album();

        session.persist(studioInUkraine);
        session.persist(studioInEngland);
        session.persist(studioInJapan2);
        session.persist(studioInJapan);
        session.persist(studioInNY);

        session.persist(wuTang);
        session.persist(oElzi);
        session.persist(akiraYamaoka);
        session.persist(djKrush);
        session.persist(infectedMushroom);

        session.getTransaction().commit();
        session.close();
    }

    static void selectCategories(){
        log.info("SELECT CATEGORIES");

        final Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        List<Artist> studios = session.createQuery("from Artist ").list();

        for (Artist s: studios) {
            Address address = s.getAddress();
            System.out.println(s.getId());
            System.out.println(s.getCategory().getName());
            System.out.println(s.getName());
            System.out.println(address.getCountry());
            System.out.println(address.getCity());
            System.out.print(address.getStreet() + " ");
            System.out.print(address.getHouse() + " ");
            System.out.println(address.getFlat());
            System.out.println("\n*****************************\n");
        }

        session.getTransaction().commit();
        session.close();
    }
}
