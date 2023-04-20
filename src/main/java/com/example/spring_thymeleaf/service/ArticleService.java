package com.example.spring_thymeleaf.service;

import com.example.spring_thymeleaf.model.Article;

import java.util.List;


public interface ArticleService {
    List<Article> getAllArticle();
    Article getArticleByID(int id);
    void addNewArticle(Article article);
}
