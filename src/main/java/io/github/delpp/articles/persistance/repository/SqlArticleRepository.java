package io.github.delpp.articles.persistance.repository;

import io.github.delpp.articles.persistance.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlArticleRepository extends ArticleRepository, JpaRepository<Article, Integer> {

}
