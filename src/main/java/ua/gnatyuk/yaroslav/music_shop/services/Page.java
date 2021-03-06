package ua.gnatyuk.yaroslav.music_shop.services;

import ua.gnatyuk.yaroslav.music_shop.domain.article.Article;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Album;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Artist;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Category;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Studio;
import ua.gnatyuk.yaroslav.music_shop.domain.user.User;
import ua.gnatyuk.yaroslav.music_shop.services.impl.PageImpl;

import java.util.List;

/**
 * Created by yaroslav on 5/2/16.
 */
public interface Page {
    void buildNewPage(int numberOfCurrentPage, PageImpl.TypeOfMaterial type);
    int FIRST_PAGE = 1;

    List getPage(int number);

    long getTotalMaterials();
    int getLastPage();

    List<User> getUsers();
    List<Album> getAlbums();
    List<Category> getCategories();
    List<Artist> getArtists();
    List<Studio> getStudios();
    List<String> getValueButtonsInPagination();
    List<Article> getArticles();

    Integer getCurrentPage();
    int getMaterialsPerOnePage();

    void setResultOfAction(Object element, PageImpl.TypeOfMaterial type);
}
