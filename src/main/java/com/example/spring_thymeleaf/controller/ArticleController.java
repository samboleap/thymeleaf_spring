package com.example.spring_thymeleaf.controller;

import com.example.spring_thymeleaf.model.Article;
import com.example.spring_thymeleaf.model.request.ArticleRequest;
import com.example.spring_thymeleaf.service.ArticleService;
import com.example.spring_thymeleaf.service.AuthorService;
import com.example.spring_thymeleaf.service.FileUploadService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Comparator;

@Controller

public class ArticleController {
    // create the service for the controller

    // 3 dependency injection
    // 1/. constructor injection
//    AuthorService authorService;
//    @Autowired
//    ArticleController (AuthorService authorService){
//        this.authorService = authorService;
//    }

    // 2/. field injection
//    @Autowired
//    ArticleService articleService;
//    @Autowired
//    AuthorService authorService;

    // 3/. getter and setter

    ArticleService articleService;
    FileUploadService fileUploadService;
    AuthorService authorService;
    @Autowired
    ArticleController (ArticleService articleService,AuthorService authorService, FileUploadService fileUploadService){
        this.articleService = articleService;
        this.authorService = authorService;
        this.fileUploadService = fileUploadService;
    }



    @GetMapping("/allArticle")
    public String getAllArticle(Model model, HttpServletRequest httpServletRequest){
        model.addAttribute("allArticle",articleService.getAllArticle().stream().sorted((o1, o2)->
                o2.getId()-(o1.getId())));

//        model.addAttribute("allArticle",articleService.getAllArticle());
        return "allArticle";
    }
    @GetMapping("/post/{postID}")
    public String getPostByID(@PathVariable int postID, Model model){
        model.addAttribute("article", articleService.getArticleByID(postID));
        return "viewArticle";
    }
    @GetMapping("/newForm")
    public String getNewForm(Model model)
    {
        model.addAttribute("article", new ArticleRequest());
        model.addAttribute("authors", authorService.getAllAuthor());
        return "newForm";
    }

    @PostMapping("/handleAddArticle")
    public String handleAddArticle(@Valid @ModelAttribute("article")  ArticleRequest article,
                                   BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            System.out.println("Errors has happened!!!");
//            model.addAttribute("article", new ArticleRequest());
            model.addAttribute("authors", authorService.getAllAuthor());
            return "/newForm";
        }
        Article newArticle = new Article();
        try {
            String fileNames ="http://localhost:8080/images/"+ fileUploadService.uploadFile(article.getFile());
            newArticle.setImgURL(fileNames);
//            System.out.println("FileName is :" +fileNames);
        }catch (Exception e){
            newArticle.setImgURL("https://developers.elementor.com/docs/assets/img/elementor-placeholder-image.png");
            System.out.println("Error: " +e.getMessage());
        }

        System.out.println("Here is the value of article: " +article);

        // mapstrust vs model mapper


        newArticle.setTitle(article.getTitle());
        newArticle.setDescription(article.getDescription());
//        newArticle.setImgURL(article.getImgURL());

        newArticle.setAuthor(authorService.getAllAuthor().stream().filter(e -> e.getId() == article.getAuthorID())
                .findFirst().orElse(null));

        // id , author
        // stream find max article (by ID )
        newArticle.setId(articleService.getAllArticle().stream().max(Comparator.comparingInt(Article::getId)).stream().toList().get(0).getId()+1);
        articleService.addNewArticle(newArticle);
        return "redirect:/allArticle";
    }
}