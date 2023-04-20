package com.example.spring_thymeleaf.repository;

import com.example.spring_thymeleaf.model.Article;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleRepository {
    private List<Article> articleList = new ArrayList<>(){{

        add(new Article(1001,"ChatGPT ", " new evolution of prompt programming ",
                "https://images.unsplash.com/photo-1575936123452-b67c3203c357?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8aW1hZ2V8ZW58MHx8MHx8&w=1000&q=80",
                new AuthorRepository().getAllAuthor().get(0)));

        add(new Article(1002,"java Programming ", " java programming is about about oop ",
                "https://images.unsplash.com/photo-1620001001197-2484c0bb0f3f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OXx8cGljdHVyZSUyMHRha2luZ3xlbnwwfHwwfHw%3D&w=1000&q=80",
                new AuthorRepository().getAllAuthor().get(2)));

        add(new Article(1003,"Football in Cambodia ", " Football is a popular sport in cambodia now",
                "https://expertphotography.b-cdn.net/wp-content/uploads/2020/05/male-photographer-taking-picture-PNWFBPY.jpg",
                new AuthorRepository().getAllAuthor().get(3)));

    }} ;
    public List<Article> getAllArticle(){
        return articleList;
    }
    public Article getArticleByID(int id){
        return articleList.stream().filter(e-> e.getId()==id).findFirst().orElse(null);
    }
    public void addNewArticle(Article article){
        articleList.add(article);
    }

}
