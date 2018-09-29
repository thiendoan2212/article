package com.a97lynk.article.reponsitory;

import com.a97lynk.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
