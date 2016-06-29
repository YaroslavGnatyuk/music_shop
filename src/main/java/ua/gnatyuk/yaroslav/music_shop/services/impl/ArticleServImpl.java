package ua.gnatyuk.yaroslav.music_shop.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.gnatyuk.yaroslav.music_shop.dao.DaoPersist;
import ua.gnatyuk.yaroslav.music_shop.domain.article.Article;
import ua.gnatyuk.yaroslav.music_shop.services.ArticleService;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by yaroslav on 6/19/16.
 */

@Service
public class ArticleServImpl implements ArticleService{
    @Inject
    @Named(value = "articleDAO")
    DaoPersist<Article> daoPersist;

    @Override
    @Transactional
    public void createNewArticle(Article article) {
        daoPersist.create(article);
    }
}
