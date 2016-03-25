package application.best_rate;

import domain.musicrecord.Artist;

import java.util.List;

/**
 * Created by yaroslav on 24.03.16.
 */
public interface getTopArtist {
    List<Artist> getTop10ByRating();
    List<Artist> getTop10BySales();

}
