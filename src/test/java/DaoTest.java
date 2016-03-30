import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.gnatyuk.yaroslav.music_shop.SpringConfiguration;
import ua.gnatyuk.yaroslav.music_shop.dao.DaoPersist;
import ua.gnatyuk.yaroslav.music_shop.domain.FillDataBase;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Artist;

import javax.inject.Inject;

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
    private DaoPersist<Artist> artistDAO;

    @Before
    public void addData(){
        fillDataBase.deleteOldDataFromDB();
        fillDataBase.addDataToDB();
    }
    @Test
    public void findArtist(){
        Long id = new Long(1);
        assertEquals(artistDAO.findById(id).getName(),"Wu-tang clan");
    }

    @Test
    public void
}