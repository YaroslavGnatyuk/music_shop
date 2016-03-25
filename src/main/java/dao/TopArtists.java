package dao;

import domain.musicrecord.Artist;

import java.util.List;

/**
 * Created by yaroslav on 24.03.16.
 */
public interface TopArtists {
    List<Artist> getTop10ArtistsByRating();
    List<Artist> getTop10ArtistsBySales();
    List<Artist> getTheBestArtists();
}
