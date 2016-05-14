package ua.gnatyuk.yaroslav.music_shop.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.gnatyuk.yaroslav.music_shop.dao.DaoPersist;
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

    private DaoPersist daoPersist;

    List albums;
    List categories;
    List artists;
    List studios;
    List users;

    TypeOfMaterial type;

    private long totalOfMaterials;
    private int lastPage = 1;
    private Integer currentPage = 1;

    private static final int MATERIALS_PER_ONE_PAGE = 3;
    private static final int SIZE_OF_PAGINATION = 9;

    List<String> valueButtonsInPagination;

    public enum TypeOfMaterial {
        ARTIST,CATEGORY,ALBUM,STUDIO,USER
    }

    @Transactional
    @Override
    public void buildNewPage(int currentPage, TypeOfMaterial type) {
        if(currentPage < 1)
            currentPage = 1;
        if(currentPage > lastPage )
            currentPage = lastPage;

        setTypeOfMaterials(type);

        this.currentPage = currentPage;

        if (this.type.name().equals(TypeOfMaterial.ALBUM.toString())){
            albums = daoPersist.getMaterialsForOnePage((currentPage - 1) * MATERIALS_PER_ONE_PAGE, MATERIALS_PER_ONE_PAGE);
        }

        if (this.type.name().equals(TypeOfMaterial.ARTIST.toString())){
            artists = daoArtist.getMaterialsForOnePage((currentPage - 1) * MATERIALS_PER_ONE_PAGE, MATERIALS_PER_ONE_PAGE);
        }

        if (this.type.name().equals(TypeOfMaterial.CATEGORY.toString())){
            categories = daoPersist.getMaterialsForOnePage((currentPage - 1) * MATERIALS_PER_ONE_PAGE, MATERIALS_PER_ONE_PAGE);
        }

        if (this.type.name().equals(TypeOfMaterial.STUDIO.toString())){
            studios = daoPersist.getMaterialsForOnePage((currentPage - 1) * MATERIALS_PER_ONE_PAGE, MATERIALS_PER_ONE_PAGE);
        }

        if (this.type.name().equals(TypeOfMaterial.USER.toString())){
            users = daoPersist.getMaterialsForOnePage((currentPage - 1) * MATERIALS_PER_ONE_PAGE, MATERIALS_PER_ONE_PAGE);
        }
        setQuantityOfMaterials();
        setQuantityOfPages();
        setValueButtonsInPagination();
    }

    private void setTypeOfMaterials(TypeOfMaterial type){
        this.type = type;

        if (this.type.name().equals(TypeOfMaterial.ALBUM.toString())){
            daoPersist = daoAlbum;
        }

        if (this.type.name().equals(TypeOfMaterial.ARTIST.toString())){
            daoPersist = daoArtist;
        }

        if (this.type.name().equals(TypeOfMaterial.CATEGORY.toString())){
            daoPersist = daoCategory;
        }

        if (this.type.name().equals(TypeOfMaterial.STUDIO.toString())){
            daoPersist = daoStudio;
        }
        if (this.type.name().equals(TypeOfMaterial.USER.toString())){
            daoPersist = daoUser;
        }
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

    @Transactional
    private void setQuantityOfMaterials() {
        this.totalOfMaterials = daoPersist.getTotalRecords();
    }

    public void setQuantityOfPages() {
            lastPage = 0;
            long materials = totalOfMaterials;

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
    public long getTotalOfMaterials() {
        return totalOfMaterials;
    }
    @Override
    public int getLastPage() {
        return lastPage;
    }

    @Override
    public List<String> getValueButtonsInPagination() {
        return valueButtonsInPagination;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getMaterialsPerOnePage() {
        return MATERIALS_PER_ONE_PAGE;
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
                ", totalOfMaterials=" + totalOfMaterials +
                ", lastPage=" + lastPage +
                ", currentPage=" + currentPage +
                ", MATERIALS_PER_ONE_PAGE=" + MATERIALS_PER_ONE_PAGE +
                '}';
    }
}
