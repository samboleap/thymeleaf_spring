package com.example.spring_thymeleaf.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileConfiguration implements WebMvcConfigurer {
    //http://:localhost:8080.images/fagerarga.jpg

//     String serverPath = "D:\\Istad 1st gen\\Spring\\doc\\Spring thymeleaf\\src\\main\\resources\\images\\";
//     String clientPath = "/images/**";

    @Value("${server.path}")
    String serverPath;
    @Value("${client.path}")
    String clientPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(clientPath)
                .addResourceLocations("file:"+serverPath);
//        WebMvcConfigurer.super.addResourceHandlers(registry);

    }
}
