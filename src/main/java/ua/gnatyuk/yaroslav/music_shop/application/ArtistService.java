package ua.gnatyuk.yaroslav.music_shop.application;

import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Artist;

import java.util.List;

/**
 * Created by yaroslav on 31.03.16.
 */
public interface ArtistService {
    Artist findById(Long id);
    Artist findByName(String nameOfTheStudio);

    void createArtist(Artist artist);
    void updateArtist(Artist artist);
    void deleteArtist(Artist artist);

    List<Artist> getAll();
    long getCountArtists();
}
