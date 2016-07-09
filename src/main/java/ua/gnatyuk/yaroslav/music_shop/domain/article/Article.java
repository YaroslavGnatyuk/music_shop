package ua.gnatyuk.yaroslav.music_shop.domain.article;

import javax.persistence.*;
import java.time.LocalDate;

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
    private String name;

    @Column(name = "date")
    LocalDate date;

    @Column(name = "article")
    private String article;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "author")
    private String author;

    public Article() {
    }

    public Article(String author, String name, String article) {
        this.author = author;
        this.name = name;
        this.article = article;
       this.setShortDesription();
    }

    public Article(String author, String name, String article, String shortDescription) {
        this.article = article;
        this.author = author;
        this.name = name;
        this.shortDescription = shortDescription;
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

    public void setShortDesription(){
        if(article.length() >300) {
            shortDescription = article.substring(0, 300) + "...";
        }
        else
            shortDescription = article;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Article{" +
                "author='" + author + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", article='" + article + '\'' +
                ", date=" + date +
                ", name='" + name + '\'' +
                '}';
    }
}
