package com.example.spring_thymeleaf.service.serviceimpl;

import com.example.spring_thymeleaf.service.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    Path fileLocationStorage;
    FileUploadServiceImpl(){
        fileLocationStorage = Paths.get("D:\\Istad 1st gen\\Spring\\doc\\Spring thymeleaf\\src\\main\\resources\\images");
    }
    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();



        if (fileName!=null){
            // condition for fileName
            if (fileName.contains("..")){
                System.out.println("FileName is incorrect!!!");
                return null;
            }
        String[] filePaths = fileName.split("\\.");
        fileName = UUID.randomUUID()+"."+filePaths[1];

        // resolved path
            Path resolvedPath = fileLocationStorage.resolve(fileName);
            Files.copy(file.getInputStream(), resolvedPath, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        }
        else return null;
    }
}
