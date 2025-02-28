//package com.docmosis.docmosis;
//
//import com.docmosis.docmosis.Repository.temp_Repo;
//import com.docmosis.docmosis.service.DataTransferService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//
//@Controller
//@RequiredArgsConstructor
//public class ApiController {
//   @Autowired
//
//    private final temp_Repo repository;
//    private final csvUtil csvUtil;
//    @Autowired
//    private DataTransferService service;
//    @GetMapping("/upload") // Handle GET request
//    public String uploadForm() {
//        return "Upload.html";
//    }
//
//
//
//    @PostMapping(value = "/upload", consumes = "multipart/form-data")
//
//    public String uploadMultipart(@RequestParam("file") MultipartFile file) throws IOException {
//        String contentType = file.getContentType();
//        if(contentType!=null && contentType.equals("text/csv")){
//
//            repository.saveAll(csvUtil.read(file.getInputStream()));
//            return "Upload.html";}
//        else{
//            return "error.html";
//
//        }}
//    @GetMapping(value = "/upload/main")
//    public String uploadToMain(){
//        service.transferData();
//        return "Upload.html";
//
//    }
//
//
//}