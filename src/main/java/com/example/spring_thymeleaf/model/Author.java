package com.example.spring_thymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    private int id;
    private String name;
    private  String gender;
    private String bio;
}
