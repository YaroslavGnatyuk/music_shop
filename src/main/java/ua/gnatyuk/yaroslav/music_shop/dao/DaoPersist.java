package ua.gnatyuk.yaroslav.music_shop.dao;

import java.util.List;

/**
 * Created by yaroslav on 24.03.16.
 */
public interface DaoPersist <T>{
    List<T> getTop10ByRate();
    List<T> getTop10BySales();
    List<T> getTheBest(); //get 10 albums where rating and sales better at same time

    void createOrUpdate(T obj);
    T findById(Long id);
    void delete(T obj);

    public T findByName(String nameOfTheStudio);

}
