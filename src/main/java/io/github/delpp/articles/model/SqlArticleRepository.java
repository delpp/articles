package io.github.delpp.articles.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface SqlArticleRepository extends ArticleRepository, JpaRepository<Article, Integer> {

}
