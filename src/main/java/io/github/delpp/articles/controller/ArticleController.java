package io.github.delpp.articles.controller;

import io.github.delpp.articles.model.ArticleDTO;
import io.github.delpp.articles.persistance.model.Article;
import io.github.delpp.articles.service.ArticleServiceImpl;
import io.github.delpp.articles.service.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
class ArticleController {
    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
    private final ArticleServiceImpl articleService;


    ArticleController(ArticleServiceImpl articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/articles")
    ResponseEntity<ArticleDTO> createArticle(@RequestBody @Valid ArticleDTO toCreate) {

        Article result = articleService.save(toCreate);

        return ResponseEntity.created(URI.create("/" + result.getId())).body(Mapper.articleToDTO(result));
    }

    @GetMapping(value = "/articles")
    ResponseEntity<List<ArticleDTO>> readAllArticles() {
        logger.warn("Exposing all articles");
        return ResponseEntity.ok(articleService.findAll());
    }

    @GetMapping(value = "/articles", params = {"sort", "!page", "!size"})
    ResponseEntity<List<ArticleDTO>> readAllArticles(Sort sort) {
        logger.warn("Exposing all sorted articles");
        return ResponseEntity.ok(articleService.findAll(sort));
    }

    @DeleteMapping(path = "/articles/{articleId}")
    ResponseEntity<?> deleteArticle(@PathVariable("articleId") Integer id) {
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/articles/{id}")
    ResponseEntity<ArticleDTO> readArticle(@PathVariable int id) {
        return articleService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/articles/search/{word}")
    ResponseEntity<List<ArticleDTO>> readArticle(@PathVariable String word){
        return ResponseEntity.ok(
                articleService.searchByDescriptionOrTitle(word));
    }

    @PutMapping("/articles/{id}")
    ResponseEntity<?> updateArticle(@PathVariable int id, @RequestBody @Valid ArticleDTO toUpdate) {
        if (!articleService.isArticleExist(id)) {
            return ResponseEntity.notFound().build();
        } else {
            articleService.update(id, toUpdate);
            return ResponseEntity.noContent().build();
        }
    }

}

