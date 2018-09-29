package com.a97lynk.article.service;

import com.a97lynk.article.entity.Article;
import com.a97lynk.article.reponsitory.ArticleRepository;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    // get all article
    public List<Article> selectAllArticle() {
        return articleRepository.findAll();
    }

    // get a article
    public Article selectArticleById(Long id) throws ObjectNotFoundException {
        return articleRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, Article.class.getSimpleName()));
    }

    // add a new article
    public Article insertArticle(Article article){
        if (article == null) throw new TypeMismatchException("Object is null");
        return articleRepository.save(article);
    }

    // edit a article
    public Article updateArticle(Long id, Article data) throws ObjectNotFoundException{
        Article article = selectArticleById(id);
        article.setTitle(data.getTitle());
        article.setCategory(data.getCategory());
        return articleRepository.save(article);
    }

    // delete a article
    public boolean deleteArticle(Long id) throws ObjectNotFoundException {
        Article article = selectArticleById(id);
        articleRepository.delete(article);
        return (articleRepository.existsById(id) == false);
     }
}
