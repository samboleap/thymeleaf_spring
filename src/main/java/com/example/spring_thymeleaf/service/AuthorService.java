package com.example.spring_thymeleaf.service;

import com.example.spring_thymeleaf.model.Article;
import com.example.spring_thymeleaf.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthor();
}
