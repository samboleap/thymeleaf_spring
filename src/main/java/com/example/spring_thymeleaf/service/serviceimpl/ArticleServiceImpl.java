package com.example.spring_thymeleaf.service.serviceimpl;

import com.example.spring_thymeleaf.model.Article;
import com.example.spring_thymeleaf.repository.ArticleRepository;
import com.example.spring_thymeleaf.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService {
// need to call repository
    ArticleRepository articleRepository;
    ArticleServiceImpl(){
        articleRepository = new ArticleRepository();
    }
    @Override
    public List<Article> getAllArticle() {
        return articleRepository.getAllArticle();
    }

    @Override
    public Article getArticleByID(int id) {
        return articleRepository.getArticleByID(id);
    }

    @Override
    public void addNewArticle(Article article) {
        articleRepository.addNewArticle(article);
    }
}
