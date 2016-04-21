package ua.gnatyuk.yaroslav.music_shop.application;

import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Album;

import java.util.List;

/**
 * Created by yaroslav on 31.03.16.
 */
public interface AlbumService {
    Album findById(Long id);
    Album findByName(String nameOfTheStudio);

    void createAlbum(Album album);
    void updateAlbum(Album album);
    void deleteAlbum(Album album);

    List<Album> getAll();
}
