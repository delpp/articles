package io.github.delpp.articles.model;

import io.github.delpp.articles.persistance.model.Article;

import java.time.LocalDate;

public class ArticleDTO {
    private int id;
    private String title;
    private String description;
    private LocalDate publicationDate;
    private String titleOfJournal;
    private String authorName;
    private String authorSecondName;

    ArticleDTO() {
    }

    public ArticleDTO(Article source) {
        id = source.getId();
        title = source.getTitle();
        description = source.getDescription();
        publicationDate = LocalDate.parse(source.getPublicationDate());
        titleOfJournal = source.getTitleOfJournal();
        authorName = source.getAuthorName();
        authorSecondName = source.getAuthorSecondName();
    }

    public int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getTitleOfJournal() {
        return titleOfJournal;
    }

    public void setTitleOfJournal(String titleOfJournal) {
        this.titleOfJournal = titleOfJournal;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSecondName() {
        return authorSecondName;
    }

    public void setAuthorSecondName(String authorSecondName) {
        this.authorSecondName = authorSecondName;
    }

    @Override
    public String toString() {
        return "ArticleDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", publicationDate=" + publicationDate +
                ", titleOfJournal='" + titleOfJournal + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorSecondName='" + authorSecondName + '\'' +
                '}';
    }
}
