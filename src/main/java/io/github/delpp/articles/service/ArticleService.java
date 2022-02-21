package io.github.delpp.articles.service;

import io.github.delpp.articles.model.ArticleDTO;
import io.github.delpp.articles.persistance.model.Article;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    List<ArticleDTO> findAll(Sort sort);

    List<ArticleDTO> findAll();

    Optional<ArticleDTO> findById(Integer id);

    Article save(ArticleDTO entity);

    boolean isArticleExist(Integer id);

}
