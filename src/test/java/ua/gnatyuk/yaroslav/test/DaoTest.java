package ua.gnatyuk.yaroslav.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.gnatyuk.yaroslav.music_shop.SpringConfiguration;
import ua.gnatyuk.yaroslav.music_shop.application.ArtistService;
import ua.gnatyuk.yaroslav.music_shop.application.StudioService;
import ua.gnatyuk.yaroslav.music_shop.domain.FillDataBase;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Address;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Studio;

import javax.inject.Inject;

import java.time.LocalDate;

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
    private StudioService studioService;
    @Inject
    private ArtistService artistService;

    @Ignore
    @Test
    public void deleteDB(){
        fillDataBase.deleteDataFromDB();
    }

    @Ignore
    @Test
    public void createDB(){
        fillDataBase.addDataToDB();
    }

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
    public void updateStudio(){
        Studio temp = studioService.findById(new Long(1));
        temp.setName("Студия Новая для Океана Эльзы");

        studioService.updateStudio(temp);

        assertEquals(studioService.findById(new Long(1)).getName(),"Студия Новая для Океана Эльзы");

        temp.setName("Студия Океана Эльзы");
        studioService.updateStudio(temp);
    }

    @Test
    public void createStudio(){
        Studio temp = new Studio();
        temp.setName("Студия для Океана Эльзы в Запорожье");
        temp.setAddress(new Address("Ukraine", "Zaporizhya", "Boyko", "11c", 10));

        studioService.createStudio(temp);

        assertEquals(studioService.findByName("Студия для Океана Эльзы в Запорожье").
                getName(),"Студия для Океана Эльзы в Запорожье");
    }

    @Test(expected = NullPointerException.class )
    public void deleteStudio(){
        Studio studio = studioService.findByName("Студия для Океана Эльзы в Запорожье");
        studioService.deleteStudio(studio);

        studioService.findByName("Студия для Океана Эльзы в Запорожье").getName();
    }

    @Test(expected = NullPointerException.class)
    public void findArtistById(){
        Long id = new Long(1);
        assertEquals(artistService.findById(id).getName(),"The Best music record");
    }

    @Test(expected = NullPointerException.class)
    public void findArtistByName(){
        String name = "Wu-tang clan";
        assertEquals(artistService.findByName(name).getName(),"Wu-tang clan");
    }

    @Test
    public void allStudios(){
        for (int i = 0; i < studioService.getAll().size(); i++) {
            System.out.println(studioService.getAll().get(i).getName());
        }
    }

    @Test
    public void getData(){
        LocalDate localDate = LocalDate.parse("2016-04-05");
        System.out.println(localDate);
    }
}