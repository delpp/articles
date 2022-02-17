package io.github.delpp.articles.service;

import io.github.delpp.articles.model.ArticleDTO;
import io.github.delpp.articles.persistance.model.Article;
import io.github.delpp.articles.persistance.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService{
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<ArticleDTO> findAll(Sort sort){
        return articleRepository.findAll(sort).stream().map(Mapper::articleToDTO).collect(Collectors.toList());

    }

    public List<ArticleDTO> findAll(){
        return articleRepository.findAll().stream().map(Mapper::articleToDTO).collect(Collectors.toList());
    }

    public Optional<Article> findById(Integer id){
        return Optional.empty();
    }

    public Article save(ArticleDTO entity){

        return articleRepository.save(Mapper.dtoToArticle(entity));
    }

    public boolean existsById(Integer id){
        return false;
    }


}
