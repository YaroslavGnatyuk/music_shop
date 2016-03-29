import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.gnatyuk.yaroslav.music_shop.SpringConfiguration;
import ua.gnatyuk.yaroslav.music_shop.app.FillDataBase;
import ua.gnatyuk.yaroslav.music_shop.dao.album.AlbumDAO;
import ua.gnatyuk.yaroslav.music_shop.dao.artist.ArtistDAO;
import ua.gnatyuk.yaroslav.music_shop.dao.studio.StudioDAO;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Artist;

import javax.inject.Inject;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by yaroslav on 21.03.16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class DaoTest {
    @Inject
    private FillDataBase fillDataBase;
    @Inject
    private ArtistDAO artistDAO;

    @Before
    public void addData(){
//        fillDataBase.deleteOldDataFromDB();
        fillDataBase.addDataToDB();
    }
    @Test
    public void findArtist(){
        Long id = new Long(1);

        assertEquals(artistDAO.findById(id).getName(),"Wu-tang clan");
    }

    @Ignore
    @Test
    public void findStudio() {
        Long id = new Long(1);
        StudioDAO findStudio = new StudioDAO();
        assertEquals(findStudio.findById(id).getName(),"Студия Океана Эльзы");
    }

//    @Ignore
    @Test
    public void findAlbum() {
        Long id = new Long(1);
        AlbumDAO findAlbum = new AlbumDAO();
        assertEquals(findAlbum.findById(id).getName(),"The W");
    }

    @Ignore
    @Test
    public void showTopArtist(){
        ArtistDAO findArtist = new ArtistDAO();
        List<Artist> artist= findArtist.getTop10ArtistsByRating();
        for (Artist a :artist) {
            System.out.println(a.getName() + " with rating " + a.getRating());
        }
    }


}