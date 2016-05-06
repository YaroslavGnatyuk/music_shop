package ua.gnatyuk.yaroslav.music_shop.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.gnatyuk.yaroslav.music_shop.dao.DaoPersist;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Album;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Artist;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Category;
import ua.gnatyuk.yaroslav.music_shop.services.Pagination;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by yaroslav on 5/2/16.
 */
@Service
public class PaginationImpl implements Pagination{

    @Inject
    @Named(value = "artistDAO")
    private DaoPersist<Artist> daoArtist;

    @Inject
    @Named(value = "categoryDAO")
    private DaoPersist<Category> daoCategory;

    @Inject
    @Named(value = "albumDao")
    private DaoPersist<Album> daoAlbum;

    private DaoPersist daoPersist;

    List<Album> albums;
    List<Category> categories;
    List<Artist> artists;

    TypeOfMaterial type;

    private long quantityOfMaterials;
    private int lastPage = 0;
    private int currentPage = 1;
    private int previousPage = 1;
    private int MATERIALS_PER_ONE_PAGE = 1;
    private boolean isFirstPage = true;
    private boolean isLastPage = false;

    public void setTypeOfMaterials(TypeOfMaterial type){
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
    }

    @Transactional
    @Override
    public void buildNewPage(int currentPage, TypeOfMaterial type) {
        setTypeOfMaterials(type);

        previousPage = this.currentPage;
        this.currentPage = currentPage;

        if(currentPage == 1) {
            isFirstPage = true;
        }
        else{
            isFirstPage = false;
        }

        if(currentPage == lastPage){
            isLastPage = true;
        }
        else{
            isLastPage = false;
        }

        if (this.type.name().equals(TypeOfMaterial.ALBUM.toString())){
            albums = daoPersist.getMaterialsForOnePage(currentPage* MATERIALS_PER_ONE_PAGE, MATERIALS_PER_ONE_PAGE);
        }

        if (this.type.name().equals(TypeOfMaterial.ARTIST.toString())){
            artists = daoArtist.getMaterialsForOnePage(currentPage* MATERIALS_PER_ONE_PAGE, MATERIALS_PER_ONE_PAGE);
        }

        if (this.type.name().equals(TypeOfMaterial.CATEGORY.toString())){
            categories = daoPersist.getMaterialsForOnePage((currentPage - 1)* MATERIALS_PER_ONE_PAGE, MATERIALS_PER_ONE_PAGE);
        }

        setQuantityOfMaterials();
        setQuantityOfPages();
    }

    @Transactional
    public void setQuantityOfMaterials() {
        this.quantityOfMaterials = daoPersist.getTotalRecords();
    }

    public void setQuantityOfPages() {
            lastPage = 0;
            long materials = quantityOfMaterials;

            for (   ; materials > 0; materials -= MATERIALS_PER_ONE_PAGE) {
                lastPage++;
            }
    }

    @Override
    public List getPage(int number) {
        return null;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getMATERIALS_PER_ONE_PAGE() {
        return MATERIALS_PER_ONE_PAGE;
    }

    public void setMATERIALS_PER_ONE_PAGE(int MATERIALS_PER_ONE_PAGE) {
        this.MATERIALS_PER_ONE_PAGE = MATERIALS_PER_ONE_PAGE;
    }

    public long getQuantityOfMaterials() {
        return quantityOfMaterials;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public enum TypeOfMaterial {
        ARTIST,CATEGORY,ALBUM
    }

    public DaoPersist<Artist> getDaoArtist() {
        return daoArtist;
    }

    public int getPreviousPage() {
        return previousPage;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public DaoPersist getDaoPersist() {
        return daoPersist;
    }

    public DaoPersist<Album> getDaoAlbum() {
        return daoAlbum;
    }

    public DaoPersist<Category> getDaoCategory() {
        return daoCategory;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public TypeOfMaterial getType() {
        return type;
    }



    @Override
    public String toString() {
        return "PaginationImpl{" +
                "type=" + type +
                ", quantityOfMaterials=" + quantityOfMaterials +
                ", lastPage=" + lastPage +
                ", currentPage=" + currentPage +
                ", previousPage=" + previousPage +
                ", MATERIALS_PER_ONE_PAGE=" + MATERIALS_PER_ONE_PAGE +
                ", isFirstPage=" + isFirstPage +
                ", isLastPage=" + isLastPage +
                '}';
    }
}
