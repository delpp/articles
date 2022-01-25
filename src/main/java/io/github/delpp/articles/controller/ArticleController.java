package io.github.delpp.articles.controller;

import io.github.delpp.articles.model.Article;
import io.github.delpp.articles.model.ArticleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.sql.Timestamp;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

@RestController
class ArticleController {
    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
    private final ArticleRepository repository;


    ArticleController(final ArticleRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/articles")
    ResponseEntity<Article> createArticle(@RequestBody @Valid Article toCreate){
        toCreate.setArticleSaveDate(LocalDateTime.now());

        Article result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @GetMapping(value = "/articles")
    ResponseEntity<List<Article>> readAllArticles(Sort sort){
        logger.warn("Exposing all articles");
        return ResponseEntity.ok(repository.findAll(sort.descending()));
    }

    @GetMapping("/articles/{id}")
    ResponseEntity<Article> readArticle(@PathVariable int id){
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/articles/{id}")
    ResponseEntity<?> updateArticle(@PathVariable int id, @RequestBody @Valid Article toUpdate){
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        toUpdate.setId(id);
        repository.save(toUpdate);
        return ResponseEntity.noContent().build();
    }

}
