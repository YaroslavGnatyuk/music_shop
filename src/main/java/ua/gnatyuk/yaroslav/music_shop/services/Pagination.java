package ua.gnatyuk.yaroslav.music_shop.services;

import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Album;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Artist;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Category;
import ua.gnatyuk.yaroslav.music_shop.services.impl.PaginationImpl;

import java.util.List;

/**
 * Created by yaroslav on 5/2/16.
 */
public interface Pagination<T> {
    void buildNewPage(int numberOfCurrentPage, PaginationImpl.TypeOfMaterial type);
    int FIRST_PAGE = 1;

    List getPage(int number);

    void setQuantityOfMaterials();
    long getQuantityOfMaterials();
    void setTypeOfMaterials(PaginationImpl.TypeOfMaterial type);
    int getLastPage();
    List<Album> getAlbums();
    List<Category> getCategories();
    List<Artist> getArtists();
    int getCurrentPage();
    int getPreviousPage();
}
