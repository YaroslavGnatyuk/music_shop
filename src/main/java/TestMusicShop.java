import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.musicrecord.Address;
import domain.musicrecord.Album;
import domain.musicrecord.Artist;
import domain.musicrecord.Category;
import domain.musicrecord.Studio;

/**
 * Created by yaroslav on 13.03.16.
 */
public class TestMusicShop {

	private static final Logger log = LoggerFactory.getLogger(TestMusicShop.class);
	static SessionFactory sessionFactory;

	public static void main(String[] args) {
		sessionFactory = new Configuration().configure().buildSessionFactory();

		addDataToDB();
		selectCategories();

		// insertCategory();

		sessionFactory.close();
	}

	static void addDataToDB() {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();

		Stream.of("Pop", "Rock", "Hip-Hop", "Elecnronic music", "Classic music").map(Category::new).forEach(session::persist);

		Address oeAddress = new Address("Ukraine", "Kiev", "Michail Grushevskiy str.", "12-b", 12);
		Address mushroomAddress = new Address("England", "Manchester", "Arsenicheva str.", "1", 145);
		Address krushAddress = new Address("Japan", "Osaka", "Backer str.", "221-b", 1);
		Address akiroAddress = new Address("Japan", "Tokio", "Koroleva str.", "111", 31);
		Address wuTangAddress = new Address("USA", "Brookln", "some street", "21", 00);

		Studio studioInUkraine = new Studio("Студия Океана Эльзы", oeAddress);
		Studio studioInEngland = new Studio("Infected Mushroom's studio", mushroomAddress);
		Studio studioInJapan2 = new Studio("Dj Krush's studio", krushAddress);
		Studio studioInJapan = new Studio("Akiros studio", akiroAddress);
		Studio studioInNY = new Studio("Wu-Tang clans studio", wuTangAddress);

		List<Category> category = session.createQuery("from Category").list();

		Artist wuTang = new Artist("Wu-tang clan", wuTangAddress, LocalDate.of(1992, 10, 19), new ArrayList<Album>(), "wutang@gmail.com", category.get(2), studioInNY);
		Artist oElzi = new Artist("Океан Эльзы", oeAddress, LocalDate.of(1994, 1, 1), new ArrayList<Album>(), "oe@gmail.com", category.get(1), studioInUkraine);
		Artist djKrush = new Artist("Dj Krush", krushAddress, LocalDate.of(1962, 7, 27), new ArrayList<Album>(), "krush@gmail.com", category.get(3), studioInJapan2);
		Artist infectedMushroom = new Artist("Infected Mushroom", mushroomAddress, LocalDate.of(1996, 1, 1), new ArrayList<Album>(), "mushroom@gmail.com", category.get(3), studioInEngland);
		Artist akiraYamaoka = new Artist("Akira Yamaoka", akiroAddress, LocalDate.of(1968, 2, 6), new ArrayList<Album>(), "silent@gmail.com", category.get(3), studioInJapan);

		Album wuAlbum1 = new Album("The W", LocalDate.of(1994, 1, 1), wuTang, category.get(2), studioInNY);
		Album elziAlbum1 = new Album("Я на неби", LocalDate.of(1998, 1, 1), oElzi, category.get(1), studioInUkraine);
		Album krushAlbum1 = new Album("Some album", LocalDate.of(1998, 1, 1), djKrush, category.get(3), studioInJapan2);
		Album mushroomAlbum1 = new Album("Some album", LocalDate.of(1998, 1, 1), infectedMushroom, category.get(3), studioInEngland);
		Album akiraAlbum1 = new Album("Some album", LocalDate.of(1998, 1, 1), akiraYamaoka, category.get(3), studioInJapan);

		session.persist(wuAlbum1);
		session.persist(elziAlbum1);
		session.persist(krushAlbum1);
		session.persist(mushroomAlbum1);
		session.persist(akiraAlbum1);

		wuTang.getAlbums().add(wuAlbum1);
		oElzi.getAlbums().add(elziAlbum1);
		djKrush.getAlbums().add(krushAlbum1);
		infectedMushroom.getAlbums().add(mushroomAlbum1);
		akiraYamaoka.getAlbums().add(akiraAlbum1);

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

	static void selectCategories() {
		log.info("SELECT CATEGORIES");

		final Session session = sessionFactory.openSession();
		session.getTransaction().begin();

		List<Artist> studios = session.createQuery("from Artist ").list();

		for (Artist s : studios) {
			Address address = s.getAddress();
			System.out.println(s.getId());
			System.out.println(s.getCategory().getName());
			System.out.println(s.getName());
			System.out.println(s.getAlbums().get(0).getName());
			System.out.println(address.getCountry());
			System.out.println(address.getCity());
			System.out.println(address.getStreet() + " ");
			System.out.println(address.getHouse() + " ");
			System.out.println(address.getFlat());
			System.out.println("\n*****************************\n");
		}

		session.getTransaction().commit();
		session.close();
	}

	static void insertCategory() {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();

		Stream.of("Pop", "Rock", "Hip-Hop", "Elecnronic music", "Classic music").map(Category::new).forEach(session::persist);

		session.getTransaction().commit();
		session.close();
	}
}