package io.github.delpp.articles.service;

import io.github.delpp.articles.model.ArticleDTO;
import io.github.delpp.articles.persistance.model.Article;
import io.github.delpp.articles.persistance.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;
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

    public Optional<ArticleDTO> findById(Integer id){
        return articleRepository.findById(id).map(Mapper::articleToDTO);
    }

    public Article save(ArticleDTO entity){
        return articleRepository.save(Mapper.dtoToArticle(entity));
    }

    public boolean isArticleExist(Integer id){
        return articleRepository.existsById(id);
    }

    public List<ArticleDTO> searchByDescriptionOrTitle(String word){
        return articleRepository.findAll().stream().filter(x -> (x.getDescription().contains(word) || (x.getTitle().contains(word))))
                .map(Mapper::articleToDTO)
                .collect(Collectors.toList());
    }

    public void update(int id, ArticleDTO newBody){
            Article article = articleRepository.findById(id).get();
            article.setTitle(newBody.getTitle());
            article.setDescription(newBody.getDescription());
            article.setPublicationDate(String.valueOf(newBody.getPublicationDate()));
            article.setTitleOfJournal(newBody.getTitleOfJournal());
            article.setAuthorName(newBody.getAuthorName());
            article.setAuthorSecondName(newBody.getAuthorSecondName());
            //articleRepository.save(article);
    }


    public void deleteArticle(Integer id) {
        articleRepository.deleteById(id);
    }
}
