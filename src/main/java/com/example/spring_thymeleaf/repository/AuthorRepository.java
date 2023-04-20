package com.example.spring_thymeleaf.repository;

import com.example.spring_thymeleaf.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorRepository {
    List<Author> authors = new ArrayList<>(){{
        add(new Author(1001,"james","male","nothing last forever"));
        add(new Author(1002,"buna","male","nothing last forever"));
        add(new Author(1003,"jeje","female","nothing last forever"));
        add(new Author(1004,"nene","female","nothing last forever"));
    }};

    public List<Author> getAllAuthor(){
        return authors;
    }
}
