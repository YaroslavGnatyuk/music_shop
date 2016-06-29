package ua.gnatyuk.yaroslav.music_shop.domain.article;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaroslav on 6/19/16.
 */
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    String name;

    @Column(name = "article")
    private String article;

    @Column(name = "short_description")
    String shortDescription;

    @Column(name = "author")
    String author;

    public Article() {
    }

    public Article(String author, String name, String article) {
        this.author = author;
        this.name = name;
        this.article = article;
        shortDescription = getShortDesription(article);
    }

    public Article(String author, String name, String article, String shortDescription) {
        this.article = article;
        this.author = author;
        this.name = name;
        this.shortDescription = shortDescription;
    }

    private String getShortDesription(String article){
        return new String(article.substring(0, 300) + "...");
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
