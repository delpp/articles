package io.github.delpp.articles.controller;

import io.github.delpp.articles.model.ArticleDTO;
import io.github.delpp.articles.persistance.model.Article;
import io.github.delpp.articles.persistance.repository.ArticleRepository;
import io.github.delpp.articles.service.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
class ArticleController {
    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
    private final ArticleRepository repository;


    ArticleController(final ArticleRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/articles")
    ResponseEntity<ArticleDTO> createArticle(@RequestBody @Valid ArticleDTO toCreate){
        Article result = Mapper.dtoToArticle(toCreate);

        result.setArticleSaveDate(LocalDateTime.now());

        ArticleDTO toOut =  Mapper.articleToDTO(repository.save(result));

        return ResponseEntity.created(URI.create("/" + result.getId())).body(toOut);
    }

    @GetMapping(value = "/articles")
    ResponseEntity<List<ArticleDTO>> readAllArticles(Sort sort){
        logger.warn("Exposing all articles");
        return ResponseEntity.ok(repository.findAll(sort.descending()).stream().map(x -> Mapper.articleToDTO(x)).collect(Collectors.toList()));
    }

    @GetMapping("/articles/{id}")
    ResponseEntity<ArticleDTO> readArticle(@PathVariable int id){
        return repository.findById(id)
                .map(x -> Mapper.articleToDTO(x))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/articles/search/{word}")
    ResponseEntity<List<ArticleDTO>> readArticle(@PathVariable String word){
        return ResponseEntity.ok(
                repository
                .findAll()
                .stream()
                .filter(x -> (x.getDescription().contains(word) || (x.getTitle().contains(word))))
                        .sorted()
                        .map(x -> Mapper.articleToDTO(x))
                        .collect(Collectors.toList()));
    }

    @PutMapping("/articles/{id}")
    ResponseEntity<?> updateArticle(@PathVariable int id, @RequestBody @Valid ArticleDTO toUpdate){
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Article article = Mapper.dtoToArticle(toUpdate);
        article.setId(id);

        repository.save(article);
        return ResponseEntity.noContent().build();
    }

}
