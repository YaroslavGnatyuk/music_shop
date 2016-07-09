package ua.gnatyuk.yaroslav.music_shop.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.gnatyuk.yaroslav.music_shop.dao.DaoPersist;
import ua.gnatyuk.yaroslav.music_shop.domain.article.Article;
import ua.gnatyuk.yaroslav.music_shop.services.ArticleService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by yaroslav on 6/19/16.
 */

@Service
public class ArticleServImpl implements ArticleService{
    @Inject
    @Named(value = "articleDAO")
    DaoPersist<Article> daoArticle;

    @Override
    @Transactional
    public void createNewArticle(Article article) {
        daoArticle.create(article);
    }

    @Override
    public long getTotalRecords() {
        return daoArticle.getTotalRecords();
    }

    @Override
    public List getMaterialsForOnePage(int begin, int sizeOfPart) {
        return daoArticle.getMaterialsForOnePage(begin, sizeOfPart);
    }

    @Override
    @Transactional
    public void deleteArticle(Article article) {
        daoArticle.delete(article);
    }

    @Override
    @Transactional
    public Article findById(Long id) {
        return daoArticle.findById(id);
    }

    @Override
    @Transactional
    public void updateArticle(Article article) {
        daoArticle.update(article);
    }
}
