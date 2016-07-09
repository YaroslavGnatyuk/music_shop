package ua.gnatyuk.yaroslav.music_shop.services;

import ua.gnatyuk.yaroslav.music_shop.domain.article.Article;

import java.util.List;

/**
 * Created by yaroslav on 6/19/16.
 */
public interface ArticleService {
    void createNewArticle(Article article);
    void updateArticle(Article article);
    void deleteArticle(Article article);
    long getTotalRecords();
    Article findById(Long id);
    List getMaterialsForOnePage(int begin, int sizeOfPart);
}
