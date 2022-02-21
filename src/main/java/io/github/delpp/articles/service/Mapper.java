package io.github.delpp.articles.service;

import io.github.delpp.articles.model.ArticleDTO;
import io.github.delpp.articles.persistance.model.Article;

public class Mapper {

    public static ArticleDTO articleToDTO(Article article){
        return new ArticleDTO(article);
    }

    public static Article dtoToArticle(ArticleDTO articleDTO){
        return new Article(
                articleDTO.getTitle(),
                articleDTO.getDescription(),
                articleDTO.getPublicationDate(),
                articleDTO.getTitleOfJournal(),
                articleDTO.getAuthorName(),
                articleDTO.getAuthorSecondName());
    }
}
