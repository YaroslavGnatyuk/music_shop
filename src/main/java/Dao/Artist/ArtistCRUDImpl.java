package Dao.Artist;

import Dao.interfaces.CRUDOperations;
import domain.musicrecord.Artist;

/**
 * Created by yaroslav on 21.03.16.
 */
public class ArtistCRUDImpl implements CRUDOperations<Artist> {

    @Override
    public void createOrUpdate(Artist obj) {

    }

    @Override
    public Artist findById(int id) {
        return null;
    }

    @Override
    public void delete(Artist obj) {

    }
}

