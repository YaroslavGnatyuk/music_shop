package ua.gnatyuk.yaroslav.music_shop.application.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.gnatyuk.yaroslav.music_shop.application.CategoryService;
import ua.gnatyuk.yaroslav.music_shop.dao.DaoPersist;
import ua.gnatyuk.yaroslav.music_shop.domain.musicrecord.Category;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by yaroslav on 4/11/16.
 */
@Service
public class CategoryServImpl implements CategoryService {
    @Inject
    @Named(value = "categoryDAO")
    DaoPersist<Category> daoCategory;

    @Transactional
    @Override
    public Category findById(Long id) {
        return daoCategory.findById(id);
    }

    @Transactional
    @Override
    public Category findByName(String nameOfTheStudio) {
        return daoCategory.findByName(nameOfTheStudio);
    }

    @Transactional
    @Override
    public void createCategory(Category category) {
        daoCategory.create(category);
    }

    @Transactional
    @Override
    public void updateCategory(Category category) {
        daoCategory.update(category);
    }

    @Transactional
    @Override
    public void deleteCategory(Category category) {
        daoCategory.delete(category);
    }

    @Transactional
    @Override
    public List<Category> getAll() {
        return daoCategory.getAll();
    }
}
