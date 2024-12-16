package com.example.bookauther.controller;

import com.example.bookauther.entity.Publication;
import com.example.bookauther.serviceImpl.PublicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicationController {

    @Autowired
    private PublicationServiceImpl publicationService;


    @PostMapping("/addPublication/{bookId}")
    public Publication addPublication(@RequestBody Publication publication, @PathVariable Integer bookId){
       return publicationService.savePublication(publication,bookId);
    }
}
