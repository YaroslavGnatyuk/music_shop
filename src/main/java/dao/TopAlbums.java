package dao;

import domain.musicrecord.Album;

import java.util.List;

/**
 * Created by yaroslav on 24.03.16.
 */
public interface TopAlbums {
    List<Album> getTop10AlbumsByRate();
    List<Album> getTop10AlbumsBySales();
    List<Album> getTheBestAlbums(); //get 10 albums where rating and sales better at same time
}
