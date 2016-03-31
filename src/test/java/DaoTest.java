import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.gnatyuk.yaroslav.music_shop.SpringConfiguration;
import ua.gnatyuk.yaroslav.music_shop.application.ArtistService;
import ua.gnatyuk.yaroslav.music_shop.application.StudioService;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

/**
 * Created by yaroslav on 21.03.16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class DaoTest {
   /* @Inject
    private FillDataBase fillDataBase;*/

    @Inject
    private StudioService studioService;
    @Inject
    private ArtistService artistService;

    /*@Before
    public void createDataBase(){
        fillDataBase.addDataToDB();
    }
    @After*/
    /*public void deleteDataBase(){
        fillDataBase.deleteDataFromDB();
    }*/


    @Test
    public void findStudioById(){
        Long id = new Long(1);
        assertEquals(studioService.findById(id).getName(),"Студия Океана Эльзы");
    }

    @Test
    public void findStudioByName(){
        String name = "Студия Океана Эльзы";
        assertEquals(studioService.findByName(name).getName(),"Студия Океана Эльзы");
    }

    @Test
    public void findArtistoById(){
        Long id = new Long(1);
        assertEquals(artistService.findById(id).getName(),"Wu-tang clan");
    }

    @Test
    public void findArtistByName(){
        String name = "Wu-tang clan";
        assertEquals(artistService.findByName(name).getName(),"Wu-tang clan");
    }

}