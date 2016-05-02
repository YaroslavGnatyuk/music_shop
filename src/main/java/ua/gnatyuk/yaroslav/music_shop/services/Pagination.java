package ua.gnatyuk.yaroslav.music_shop.services;

import ua.gnatyuk.yaroslav.music_shop.services.impl.PaginationImpl;

import java.util.List;

/**
 * Created by yaroslav on 5/2/16.
 */
public interface Pagination<T> {
    void buildNewPage(int pageNumber,PaginationImpl.TypeOfMaterial type);
    List getPage(int number);

    void setCountOfMaterials();
    long getCountOfMaterials();
    void setTypeOfMaterials(PaginationImpl.TypeOfMaterial type);
}
