package ua.gnatyuk.yaroslav.music_shop.dao;

import java.util.List;

/**
 * Created by yaroslav on 24.03.16.
 */
public interface DaoPersist <T>{
    List<T> getTop10ByRate();
    List<T> getTop10BySales();
    List<T> getTheBest(); //get 10 albums where rating and sales better at same time
    List<T> getAll();

    void create(T obj);
    void update(T obj);
    void delete(T obj);

    T findByName(String name);
    T findById(Long id);

    long getTotalRecords();
    List<T> getMaterialsForOnePage(int begin, int sizeOfPart);


}
