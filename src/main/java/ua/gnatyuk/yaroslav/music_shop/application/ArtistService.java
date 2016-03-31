package ua.gnatyuk.yaroslav.music_shop.application;

import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Artist;

/**
 * Created by yaroslav on 31.03.16.
 */
public interface ArtistService {
    Artist findById(Long id);
    Artist findByName(String nameOfTheStudio);
}
