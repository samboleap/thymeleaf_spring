package com.example.spring_thymeleaf.model.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleRequest {
    @NotEmpty(message = "Title can not be empty!!")
    private String title;
    @NotEmpty(message = "Description can not be empty!!!")
    private String description;

    private MultipartFile file;
// pattern use to
//    @Pattern(regexp = "\\d+" ,message = "AuthorID can be only Number")
    private int authorID;
}
