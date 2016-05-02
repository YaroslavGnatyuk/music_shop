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

    private long countOfMaterials;
    private int lastPage;
    private int currentPage = 1;
    private int previousPage = 0;
    private int materials_per_page = 4;
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


    @Override
    public void buildNewPage(int currentPage, TypeOfMaterial type) {
        setTypeOfMaterials(type);

        previousPage = this.currentPage;
        this.currentPage = currentPage;

        setCountOfPages();

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
            albums = daoPersist.getPartOfRecords(currentPage*materials_per_page, materials_per_page);
        }

        if (this.type.name().equals(TypeOfMaterial.ARTIST.toString())){
            artists = daoArtist.getPartOfRecords(currentPage*materials_per_page, materials_per_page);
        }

        if (this.type.name().equals(TypeOfMaterial.CATEGORY.toString())){
            categories = daoPersist.getPartOfRecords(currentPage*materials_per_page, materials_per_page);
        }
    }

    @Override
    public List getPage(int number) {
        return null;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setCountOfPages() {
        setCountOfMaterials();
        for (;countOfMaterials > 0;countOfMaterials -= materials_per_page)
            lastPage++;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getMaterials_per_page() {
        return materials_per_page;
    }

    public void setMaterials_per_page(int materials_per_page) {
        this.materials_per_page = materials_per_page;
    }

    public long getCountOfMaterials() {
        return countOfMaterials;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    @Transactional
    public void setCountOfMaterials() {
        this.countOfMaterials = daoPersist.getTotalRecords();
    }

    public enum TypeOfMaterial {
        ARTIST,CATEGORY,ALBUM
    }
}
