import ua.gnatyuk.yaroslav.music_shop.dao.Album.AlbumDAO;
import ua.gnatyuk.yaroslav.music_shop.dao.Artist.ArtistDAO;

import ua.gnatyuk.yaroslav.music_shop.dao.Studio.StudioDAO;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Artist;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by yaroslav on 21.03.16.
 */
public class DaoTest {
    FillDataBase fillDataBase;
    @Before
    public void addData(){
        fillDataBase.sessionFactory = new Configuration().configure().buildSessionFactory();
        FillDataBase.deleteOldDataFromDB();
        fillDataBase.sessionFactory.close();

        fillDataBase.sessionFactory = new Configuration().configure().buildSessionFactory();
        FillDataBase.addDataToDB();
        fillDataBase.sessionFactory.close();
    }
    @Ignore
    @Test
    public void findArtist(){
        ArtistDAO findArtist = new ArtistDAO();
        Long id = new Long(1);
        assertEquals(findArtist.findById(id).getName(),"Wu-tang clan");
    }

    @Ignore
    @Test
    public void findStudio() {
        Long id = new Long(1);
        StudioDAO findStudio = new StudioDAO();
        assertEquals(findStudio.findById(id).getName(),"Студия Океана Эльзы");
    }

    @Ignore
    @Test
    public void findAlbum() {
        Long id = new Long(1);
        AlbumDAO findAlbum = new AlbumDAO();
        assertEquals(findAlbum.findById(id).getName(),"The W");
    }

    @Test
    public void showTopArtist(){
        ArtistDAO findArtist = new ArtistDAO();
        List<Artist> artist= findArtist.getTop10ArtistsByRating();
        for (Artist a :artist) {
            System.out.println(a.getName() + " with rating " + a.getRating());
        }
    }


}
