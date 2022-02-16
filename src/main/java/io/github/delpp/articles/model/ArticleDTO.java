package io.github.delpp.articles.model;

import io.github.delpp.articles.persistance.model.Article;

import java.time.LocalDate;

public class ArticleDTO {
    private String title;
    private String description;
    private LocalDate publicationDate;
    private String titleOfJournal;
    private String authorName;
    private String authorSecondName;

    public ArticleDTO(Article source) {
        title = source.getTitle();
        description = source.getDescription();
        publicationDate = LocalDate.parse(source.getPublicationDate());
        titleOfJournal = source.getTitleOfJournal();
        authorName = source.getAuthorName();
        authorSecondName = source.getAuthorSecondName();
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

//    public Article toArticle(){
//       return new Article(title, description, publicationDate, titleOfJournal, authorName, authorSecondName);
//    }
}
