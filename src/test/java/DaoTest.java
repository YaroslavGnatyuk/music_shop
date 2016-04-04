import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.gnatyuk.yaroslav.music_shop.SpringConfiguration;
import ua.gnatyuk.yaroslav.music_shop.application.ArtistService;
import ua.gnatyuk.yaroslav.music_shop.application.StudioService;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Address;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Studio;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

/**
 * Created by yaroslav on 21.03.16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class DaoTest {
    /*@Inject
    private FillDataBase fillDataBase;
*/
    @Inject
    private StudioService studioService;
    @Inject
    private ArtistService artistService;

    /*
    @Before
    public void createDataBase(){
        fillDataBase.addDataToDB();
    }
    @After
    public void deleteDataBase(){
        fillDataBase.deleteDataFromDB();
    }*/


    @Test
    public void findStudioById(){
        Long id = new Long(1);
        assertEquals(studioService.findById(id).getName(),"Студия Новая для Океана Эльзы");
    }

    @Test
    public void findStudioByName(){
        String name = "Студия Новая для Океана Эльзы";
        assertEquals(studioService.findByName(name).getName(),"Студия Новая для Океана Эльзы");
    }

    @Test
    public void updateStudio(){
        Studio temp = studioService.findById(new Long(1));
        temp.setName("Студия Новая для Океана Эльзы");

        studioService.updateStudio(temp);

        assertEquals(studioService.findById(new Long(1)).getName(),"Студия Новая для Океана Эльзы");
    }

    @Test
    public void createStudio(){
        Studio temp = new Studio();
        temp.setName("Студия для Океана Эльзы");
        temp.setAddress(new Address("Ukraine", "Zaporizhya", "Boyko", "11c", 10));

        studioService.createStudio(temp);

        assertEquals(studioService.findByName("Студия для Океана Эльзы").getName(),"Студия для Океана Эльзы");
    }

    @Test(expected = java.lang.NullPointerException.class )
    public void deleteStudio(){
        Studio studio = studioService.findByName("Студия для Океана Эльзы");
        studioService.deleteStudio(studio);

        studioService.findByName("Студия для Океана Эльзы").getName();
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