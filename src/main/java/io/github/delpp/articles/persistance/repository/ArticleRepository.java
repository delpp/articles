package io.github.delpp.articles.persistance.repository;

import io.github.delpp.articles.persistance.model.Article;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository {
    List<Article> findAll(Sort descending);

    List<Article> findAll();

    Optional<Article> findById(Integer id);

    Article save(Article entity);

    //List<Article> findArticlesByTitleContains(@Param("word") String word);

    //List<Article> findArticlesByDescriptionContains(@Param("word") String word);

    boolean existsById(Integer id);


}
