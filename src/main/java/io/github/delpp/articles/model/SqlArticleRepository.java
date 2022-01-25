package io.github.delpp.articles.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface SqlArticleRepository extends ArticleRepository, JpaRepository<Article, Integer> {

    //@RestResource(path = "titlecontains", rel = "titlecontains")
    //List<Article> findArticlesByTitleContains(@Param("word") String word);

    //@RestResource(path = "desriptioncontains", rel = "desriptioncontains")
    //List<Article> findArticlesByDescriptionContains(@Param("word") String word);


}
