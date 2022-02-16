package io.github.delpp.articles.service;

import io.github.delpp.articles.model.ArticleDTO;
import io.github.delpp.articles.persistance.model.Article;

import java.time.LocalDate;

public class Mapper {

    public static ArticleDTO articleToDTO(Article article){
        ArticleDTO articleDTO = new ArticleDTO(article);
        return articleDTO;
    }

    public static Article dtoToArticle(ArticleDTO articleDTO){
        Article article = new Article(
                articleDTO.getTitle(),
                articleDTO.getDescription(),
                articleDTO.getPublicationDate(),
                articleDTO.getTitleOfJournal(),
                articleDTO.getAuthorName(),
                articleDTO.getAuthorSecondName());
        return article;
    }
}
