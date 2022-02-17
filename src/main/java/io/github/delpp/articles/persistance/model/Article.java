package io.github.delpp.articles.persistance.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Title must not be empty")
    private String title;
    private String description;
    private LocalDate publicationDate;
    private String titleOfJournal;
    private String authorName;
    private String authorSecondName;
    private LocalDateTime articleSaveDate;

    public Article() {
    }

    public Article(String title, String description, LocalDate publicationDate, String titleOfJournal, String authorName, String authorSecondName) {
        this.title = title;
        this.description = description;
        this.publicationDate = publicationDate;
        this.titleOfJournal = titleOfJournal;
        this.authorName = authorName;
        this.authorSecondName = authorSecondName;
    }

    public Article(String title, String description, LocalDate publicationDate, String titleOfJournal, String authorName, String authorSecondName, LocalDateTime articleSaveDate) {
        this.title = title;
        this.description = description;
        this.publicationDate = publicationDate;
        this.titleOfJournal = titleOfJournal;
        this.authorName = authorName;
        this.authorSecondName = authorSecondName;
        this.articleSaveDate = articleSaveDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    public String getPublicationDate() {

        return publicationDate.toString();
    }

    void setPublicationDate(String publicationDate) {

        this.publicationDate = LocalDate.parse(publicationDate);
    }

    public String getTitleOfJournal() {
        return titleOfJournal;
    }

    void setTitleOfJournal(String titleOfJournal) {
        this.titleOfJournal = titleOfJournal;
    }

    public String getAuthorName() {
        return authorName;
    }

    void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSecondName() {
        return authorSecondName;
    }

    void setAuthorSecondName(String authorSecondName) {
        this.authorSecondName = authorSecondName;
    }

    public LocalDateTime getArticleSaveDate() {
        return articleSaveDate;
    }

    public void setArticleSaveDate(LocalDateTime articleSaveDate) {
        this.articleSaveDate = articleSaveDate;
    }

    @PrePersist
    void setDataBeforeInsert(){
        this.articleSaveDate = LocalDateTime.now();
    }
}
