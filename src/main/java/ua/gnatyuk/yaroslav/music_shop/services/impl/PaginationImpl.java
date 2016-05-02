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
    DaoPersist<Artist> daoArtist;

    @Inject
    @Named(value = "categoryDAO")
    DaoPersist<Category> daoCategory;

    @Inject
    @Named(value = "albumDao")
    DaoPersist<Album> daoAlbum;

    DaoPersist daoPersist;

    long countOfMaterials;
    int countOfPages;
    int currentPage = 1;
    int materials_per_page = 4;

    public void setTypeOfMaterials(TypeOfMaterial type){
        if (type.name().equals(TypeOfMaterial.ALBUM.toString())){
            daoPersist = daoAlbum;
        }

        if (type.name().equals(TypeOfMaterial.ARTIST.toString())){
            daoPersist = daoArtist;
        }

        if (type.name().equals(TypeOfMaterial.CATEGORY.toString())){
            daoPersist = daoCategory;
        }
    }

    @Override
    public List buildNewPage() {

        return null;
    }

    @Override
    public List getPage(int number) {
        return null;
    }

    public int getCountOfPages() {
        return countOfPages;
    }

    public void setCountOfPages(int countOfPages) {
        this.countOfPages = countOfPages;
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

    @Transactional
    public void setCountOfMaterials() {
        this.countOfMaterials = daoPersist.getTotalRecords();
    }

    public enum TypeOfMaterial {
        ARTIST,CATEGORY,ALBUM
    }
}
