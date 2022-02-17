package io.github.delpp.articles.service;

import io.github.delpp.articles.model.ArticleDTO;
import io.github.delpp.articles.persistance.model.Article;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    List<ArticleDTO> findAll(Sort sort);

    List<ArticleDTO> findAll();

    Optional<Article> findById(Integer id);

    Article save(ArticleDTO entity);

    //List<Article> findArticlesByTitleContains(@Param("word") String word);

    //List<Article> findArticlesByDescriptionContains(@Param("word") String word);

    boolean existsById(Integer id);

}
