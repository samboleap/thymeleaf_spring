package com.example.spring_thymeleaf;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

@SpringBootApplication
public class SpringThymeleafApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringThymeleafApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Locale locale = LocaleContextHolder.getLocale();
//        System.out.println();

        Locale currentlocale = LocaleContextHolder.getLocale();
        String countryName = currentlocale.getDisplayName();
        System.out.println("Country Name is: " +countryName);

        String languageCode = currentlocale.getLanguage();
        System.out.println("Language Code is: " +languageCode);

        // write code to show all the languages code
        String[] languages = Locale.getISOLanguages();
        for (String lang: languages){
            Locale locale = new Locale(lang);
            System.out.println("Language Code are :" +locale.getLanguage()+ "->"+locale.getDisplayLanguage());

        }
    }
}
