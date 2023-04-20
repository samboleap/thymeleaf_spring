package com.example.spring_thymeleaf.service.serviceimpl;

import com.example.spring_thymeleaf.model.Author;
import com.example.spring_thymeleaf.repository.AuthorRepository;
import com.example.spring_thymeleaf.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;
    AuthorServiceImpl(){
        authorRepository = new AuthorRepository();
    }
    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.getAllAuthor();
    }

}
