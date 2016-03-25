import dao.Studio.StudioCRUDImpl;
import domain.musicrecord.Address;
import domain.musicrecord.Studio;
import org.junit.Test;

/**
 * Created by yaroslav on 21.03.16.
 */
public class DaoTest {
    @Test
    public void addStudio(){
        Address address = new Address("USA", "L.A.", "BroadWay", "777b", 1);
        Studio studio = new Studio("Hollywood",address);

        StudioCRUDImpl studioCRUD = new StudioCRUDImpl();
        studioCRUD.createOrUpdate(studio);
    }
}
