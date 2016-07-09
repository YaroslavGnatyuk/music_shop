package ua.gnatyuk.yaroslav.music_shop.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.gnatyuk.yaroslav.music_shop.dao.DaoPersist;
import ua.gnatyuk.yaroslav.music_shop.domain.article.Article;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Album;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Artist;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Category;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Studio;
import ua.gnatyuk.yaroslav.music_shop.domain.user.User;
import ua.gnatyuk.yaroslav.music_shop.services.Page;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaroslav on 5/2/16.
 */
@Service
public class PageImpl implements Page {

    @Inject
    @Named(value = "artistDAO")
    private DaoPersist<Artist> daoArtist;
    @Inject
    @Named(value = "categoryDAO")
    private DaoPersist<Category> daoCategory;
    @Inject
    @Named(value = "albumDao")
    private DaoPersist<Album> daoAlbum;
    @Inject
    @Named(value = "studioDAO")
    private  DaoPersist<Studio> daoStudio;
    @Inject
    @Named(value = "userDAO")
    private DaoPersist<User> daoUser;
    @Inject
    @Named(value = "articleDAO")
    private DaoPersist<Article> daoArticle;

    private List albums = null;
    private List categories = null;
    private List artists = null;
    private List studios = null;
    private List users = null;
    private List articles = null;

    private TypeOfMaterial type;

    private long totalMaterials;
    private int lastPage = 1;
    private Integer currentPage = 1;

    private static final int MATERIALS_PER_ONE_PAGE = 12;
    private static final int SIZE_OF_PAGINATION = 9;

    private List<String> valueButtonsInPagination;

    public enum TypeOfMaterial {
        ARTIST,CATEGORY,ALBUM,STUDIO,USER,ARTICLE
    }

    @Transactional
    @Override
    public void buildNewPage(int currentPage, TypeOfMaterial type) {
        this.type = type;

        if(currentPage < 1)
            currentPage = 1;
        if(currentPage > lastPage )
            currentPage = lastPage;

        this.currentPage = currentPage;

        if (this.type.name().equals(TypeOfMaterial.ALBUM.toString())){
            albums = daoAlbum.getMaterialsForOnePage((currentPage - 1) * MATERIALS_PER_ONE_PAGE, MATERIALS_PER_ONE_PAGE);
            this.totalMaterials = daoAlbum.getTotalRecords();

            for (int i = 0; i < albums.size(); i++) {           //add short description for all albums on the page
                ((Album)albums.get(i)).setShortDescription();
            }
        }

        if (this.type.name().equals(TypeOfMaterial.ARTIST.toString())){
            artists = daoArtist.getMaterialsForOnePage((currentPage - 1) * MATERIALS_PER_ONE_PAGE, MATERIALS_PER_ONE_PAGE);
            this.totalMaterials = daoArtist.getTotalRecords();
        }

        if (this.type.name().equals(TypeOfMaterial.CATEGORY.toString())){
            categories = daoCategory.getMaterialsForOnePage((currentPage - 1) * MATERIALS_PER_ONE_PAGE, MATERIALS_PER_ONE_PAGE);
            this.totalMaterials = daoCategory.getTotalRecords();
        }

        if (this.type.name().equals(TypeOfMaterial.STUDIO.toString())){
            studios = daoStudio.getMaterialsForOnePage((currentPage - 1) * MATERIALS_PER_ONE_PAGE, MATERIALS_PER_ONE_PAGE);
            this.totalMaterials = daoStudio.getTotalRecords();
        }

        if (this.type.name().equals(TypeOfMaterial.USER.toString())){
            List<User> temp = daoUser.getMaterialsForOnePage((currentPage - 1) * MATERIALS_PER_ONE_PAGE, MATERIALS_PER_ONE_PAGE);
            users = new ArrayList<>(temp.size());

            for (int i = 0; i < temp.size(); i++) {
                users.add(temp.get(i));
            }
            this.totalMaterials = daoUser.getTotalRecords();
        }

        if(this.type.name().equals(TypeOfMaterial.ARTICLE.toString())){
            articles = daoArticle.getMaterialsForOnePage((currentPage - 1) * MATERIALS_PER_ONE_PAGE, MATERIALS_PER_ONE_PAGE);
            this.totalMaterials = daoArticle.getTotalRecords();
        }
        setQuantityOfPages();
        setValueButtonsInPagination();
    }

    private void setValueButtonsInPagination(){
        valueButtonsInPagination = new ArrayList<>();

        if(lastPage<SIZE_OF_PAGINATION){
            for (int i = 1; i <= lastPage; i++) {
                valueButtonsInPagination.add(Integer.toString(i));
            }
            return;
        }

        if(currentPage == 1 || currentPage == 2){
            for (int i = 1 ; i <= SIZE_OF_PAGINATION - 2 ; i++) {
                valueButtonsInPagination.add(Integer.toString(i));
            }
            valueButtonsInPagination.add("..");
            valueButtonsInPagination.add(Integer.toString(lastPage));
            return;
        }

        if(currentPage > 2 && currentPage < lastPage - 1){
            valueButtonsInPagination.add("1");
            valueButtonsInPagination.add("..");
            for (int i = currentPage; i < currentPage + 5; i++) {
                if(i >= lastPage)
                    break;
                valueButtonsInPagination.add(Integer.toString(i));
            }
            valueButtonsInPagination.add("..");
            valueButtonsInPagination.add(Integer.toString(lastPage));
            return;
        }

        if(currentPage == lastPage || currentPage == lastPage - 1){
            valueButtonsInPagination.add("1");
            valueButtonsInPagination.add("..");
            for (int i = lastPage-7; i <= lastPage; i++) {
                if(i > lastPage)
                    break;
                valueButtonsInPagination.add(Integer.toString(i));
            }
        }
    }

    public void setQuantityOfPages() {
            lastPage = 0;
            long materials = totalMaterials;

            for (   ; materials > 0; materials -= MATERIALS_PER_ONE_PAGE) {
                lastPage++;
            }
    }

    public void setResultOfAction(Object result, PageImpl.TypeOfMaterial type){

        if (type.name().equals(TypeOfMaterial.ALBUM.toString())){
            albums.clear();
            albums.add(result);
        }

        if (type.name().equals(TypeOfMaterial.ARTIST.toString())){
            artists.clear();
            artists.add(result);
        }

        if (type.name().equals(TypeOfMaterial.CATEGORY.toString())){
            categories.clear();
            categories.add(result);
        }

        if (type.name().equals(TypeOfMaterial.STUDIO.toString())){
            studios.clear();
            studios.add(result);
        }

        if (type.name().equals(TypeOfMaterial.USER.toString())){
            users.clear();
            users.add(result);
        }

        if (type.name().equals(TypeOfMaterial.ARTICLE.toString())){
            articles.clear();
            articles.add(result);
        }
    }

    @Override
    public List<Article> getArticles() {
        return articles;
    }
    @Override
    public List getStudios() {
        return studios;
    }
    @Override
    public List getUsers() { return users; }
    @Override
    public List getAlbums() {
        return albums;
    }
    @Override
    public List getCategories() {
        return categories;
    }
    @Override
    public List getArtists() {
        return artists;
    }
    @Override
    public List getPage(int number) {
        return null;
    }
    @Override
    public Integer getCurrentPage() {
        return currentPage;
    }
    public long getTotalMaterials() {
        return totalMaterials;
    }
    @Override
    public int getLastPage() {
        return lastPage;
    }
    @Override
    public int getMaterialsPerOnePage() {
        return MATERIALS_PER_ONE_PAGE;
    }

    @Override
    public List<String> getValueButtonsInPagination() {
        return valueButtonsInPagination;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public DaoPersist<Artist> getDaoArtist() {
        return daoArtist;
    }
    public TypeOfMaterial getType() {
        return type;
    }
    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    @Override
    public String toString() {
        return "PaginationImpl{" +
                "type=" + type +
                ", totalMaterials=" + totalMaterials +
                ", lastPage=" + lastPage +
                ", currentPage=" + currentPage +
                ", MATERIALS_PER_ONE_PAGE=" + MATERIALS_PER_ONE_PAGE +
                '}';
    }
}
