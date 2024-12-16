package com.example.bookauther.controller;

import com.example.bookauther.entity.Auther;
import com.example.bookauther.entity.Book;
import com.example.bookauther.service.BookService;
import com.example.bookauther.serviceImpl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    @PostMapping("/addBook/{autherId}")
    public Book addBook(@RequestBody Book book, @PathVariable Integer autherId){

        Book bookResult=bookService.saveBook(book,autherId);
        return bookResult;
    }

//    @PostMapping("/addBook")
//    public Book addBook(@RequestBody Book book){
//        Book book1=null;
//        return book1;
//    }


    @GetMapping("/getBookById/{bookId}")
    public Book show(@PathVariable Integer bookId){
        Book bookResult=bookService.getBookById(bookId);
        return bookResult;
    }


    @GetMapping("/getAutherByMaxPagesWritten")
    public Auther getAuther(){

        Auther auther=bookService.getAutherByMaxWrittenPagesBook();

        return auther;
    }


}
