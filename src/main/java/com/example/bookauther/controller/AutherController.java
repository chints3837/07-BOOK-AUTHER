package com.example.bookauther.controller;

import com.example.bookauther.entity.Auther;
import com.example.bookauther.service.AutherService;
import com.example.bookauther.serviceImpl.AutherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AutherController {

    @Autowired
    public AutherServiceImpl autherService;


    @PostMapping("/addAuther")
    public Auther addAuther(@RequestBody Auther auther){

        Auther autherResult=autherService.saveAuther(auther);
        return autherResult;
    }

    @GetMapping("/getAutherById/{autherId}")
    public Auther getAutherById(@PathVariable Integer autherId){
        Auther autherResult= autherService.getAutherById(autherId);
        return autherResult;
    }

    @GetMapping("/getAutherPublishInYear/{authId}/{yearOfPub}")
    public Integer getCount(@PathVariable Integer authId,@PathVariable String yearOfPub){
        Integer result= autherService.getCount(authId,yearOfPub);
        return result;
    }


}
