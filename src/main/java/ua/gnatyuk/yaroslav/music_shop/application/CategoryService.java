package ua.gnatyuk.yaroslav.music_shop.application;

import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Category;

import java.util.List;

/**
 * Created by yaroslav on 4/11/16.
 */
public interface CategoryService {
    Category findById(Long id);
    Category findByName(String nameOfTheStudio);

    void createCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(Category category);
    List<Category> getAll();
    long getCountAllCategories();
}
