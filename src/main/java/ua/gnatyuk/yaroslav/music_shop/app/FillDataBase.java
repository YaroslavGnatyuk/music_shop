package ua.gnatyuk.yaroslav.music_shop.app;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.*;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by yaroslav on 13.03.16.
 */

@Repository
public class FillDataBase {

	public static final Logger log = LoggerFactory.getLogger(FillDataBase.class);

	@Inject
	protected SessionFactory sessionFactory;


	public static void main(String[] args) {
/*		final ApplicationContext appCtx =
				new AnnotationConfigApplicationContext(SpringConfiguration.class);*/
		FillDataBase fillDB = new FillDataBase();

//		fillDB.deleteOldDataFromDB();
		fillDB.addDataToDB();
		fillDB.selectCategories();

	}


	@Transactional
	public void deleteOldDataFromDB(){

		log.info("In delete method! ");
		sessionFactory.getCurrentSession()
				.createSQLQuery("DROP TABLE IF EXISTS album,category,artist,studio;")
				.executeUpdate();
	}

	@Transactional
	public void addDataToDB() {

		log.info("In addDataToDB ! ");

		Stream.of("Pop", "Rock", "Hip-Hop", "Elecnronic music", "Classic music")
				.map(Category::new)
				.forEach(sessionFactory.getCurrentSession()::persist);

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

		List<Category> category = sessionFactory.getCurrentSession()
				.createQuery("from Category").list();

		Artist wuTang = new Artist("Wu-tang clan", wuTangAddress, LocalDate.of(1992, 10, 19), new ArrayList<Album>(), "wutang@gmail.com", category.get(2), studioInNY,new Byte((byte)9));
		Artist oElzi = new Artist("Океан Эльзы", oeAddress, LocalDate.of(1994, 1, 1), new ArrayList<Album>(), "oe@gmail.com", category.get(1), studioInUkraine,new Byte((byte)7));
		Artist djKrush = new Artist("Dj Krush", krushAddress, LocalDate.of(1962, 7, 27), new ArrayList<Album>(), "krush@gmail.com", category.get(3), studioInJapan2,new Byte((byte)7));
		Artist infectedMushroom = new Artist("Infected Mushroom", mushroomAddress, LocalDate.of(1996, 1, 1), new ArrayList<Album>(), "mushroom@gmail.com", category.get(3), studioInEngland,new Byte((byte)1));
		Artist akiraYamaoka = new Artist("Akira Yamaoka", akiroAddress, LocalDate.of(1968, 2, 6), new ArrayList<Album>(), "silent@gmail.com", category.get(3), studioInJapan,new Byte((byte)3));

		Album wuAlbum1 = new Album("The W", LocalDate.of(1994, 1, 1), wuTang, category.get(2), studioInNY,new Byte((byte)2),11);
		Album elziAlbum1 = new Album("Я на неби", LocalDate.of(1998, 1, 1), oElzi, category.get(1), studioInUkraine,new Byte((byte)10),34);
		Album krushAlbum1 = new Album("Some album", LocalDate.of(1998, 1, 1), djKrush, category.get(3), studioInJapan2,new Byte((byte)9),19);
		Album mushroomAlbum1 = new Album("Some album", LocalDate.of(1998, 1, 1), infectedMushroom, category.get(3), studioInEngland,new Byte((byte)7),28);
		Album akiraAlbum1 = new Album("Some album", LocalDate.of(1998, 1, 1), akiraYamaoka, category.get(3), studioInJapan,new Byte((byte)4),3);

		sessionFactory.getCurrentSession().persist(wuAlbum1);
		sessionFactory.getCurrentSession().persist(elziAlbum1);
		sessionFactory.getCurrentSession().persist(krushAlbum1);
		sessionFactory.getCurrentSession().persist(mushroomAlbum1);
		sessionFactory.getCurrentSession().persist(akiraAlbum1);

		wuTang.setAlbums(wuAlbum1);
		oElzi.setAlbums(elziAlbum1);
		djKrush.setAlbums(krushAlbum1);
		infectedMushroom.setAlbums(mushroomAlbum1);
		akiraYamaoka.setAlbums(akiraAlbum1);

		sessionFactory.getCurrentSession().persist(studioInUkraine);
		sessionFactory.getCurrentSession().persist(studioInEngland);
		sessionFactory.getCurrentSession().persist(studioInJapan2);
		sessionFactory.getCurrentSession().persist(studioInJapan);
		sessionFactory.getCurrentSession().persist(studioInNY);

		sessionFactory.getCurrentSession().persist(wuTang);
		sessionFactory.getCurrentSession().persist(oElzi);
		sessionFactory.getCurrentSession().persist(akiraYamaoka);
		sessionFactory.getCurrentSession().persist(djKrush);
		sessionFactory.getCurrentSession().persist(infectedMushroom);
	}
	@Transactional
	public void selectCategories() {
		log.info("SELECT CATEGORIES");

		List<Artist> studios = sessionFactory.getCurrentSession().createQuery("from Artist ").list();

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

	}
}