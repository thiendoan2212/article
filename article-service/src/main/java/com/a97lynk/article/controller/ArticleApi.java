package com.a97lynk.article.controller;

import com.a97lynk.article.entity.Article;
import com.a97lynk.article.service.ArticleService;
import com.a97lynk.article.util.ApiResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/articles")
//@CrossOrigin("http://localhost:4200")
public class ArticleApi {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, ?> getAllArticle() {
        return ApiResponseBuilder.buildContainsData("List all article", articleService.selectAllArticle());
    }

    @GetMapping("/{id}")
    public Map<String, ?> getArticle(@PathVariable Long id) {
        return ApiResponseBuilder.buildContainsData("Get article#" + id, articleService.selectArticleById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, ?> postArticle(@RequestBody Article article) {
        Article insertedArticle = articleService.insertArticle(new Article(article.getTitle(), article.getCategory()));
        return ApiResponseBuilder.buildSuccess(String.format("Insert article#%d success", insertedArticle.getId()), insertedArticle);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, ?> putArticle(@PathVariable Long id, @RequestBody Article article) {
        Article updatedArticle = articleService.updateArticle(id, article);
        return ApiResponseBuilder.buildSuccess(String.format("Update article#%d success", id), updatedArticle);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, ?> deleteArticle(@PathVariable Long id) {
        boolean success = articleService.deleteArticle(id);
        if (success)
            return ApiResponseBuilder.buildSuccess(String.format("Delete article#%d success", id));
        else
            return ApiResponseBuilder.buildError(String.format("Delete article#%d fail", id));
    }
}
