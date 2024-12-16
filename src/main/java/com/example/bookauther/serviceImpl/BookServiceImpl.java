package com.example.bookauther.serviceImpl;

import com.example.bookauther.entity.Auther;
import com.example.bookauther.entity.Book;
import com.example.bookauther.entity.Publication;
import com.example.bookauther.repository.AutherRepository;
import com.example.bookauther.repository.BookRepository;
import com.example.bookauther.repository.PublicationRepository;
import com.example.bookauther.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AutherRepository autherRepository;

    @Autowired
    private PublicationRepository publicationRepository;

    public Book saveBook(Book book,Integer autherId){

        Optional<Auther> autherTemp=autherRepository.findById(autherId);

//        Optional<Publication> publicationTemp=publicationRepository.findById(pubId);


        List<Book> autherBookList= autherTemp.get().getBookList();

        Book bookTemp=new Book();
        bookTemp.setAuther(autherTemp.get());
        bookTemp.setbName(book.getbName());
        bookTemp.setbPages(book.getbPages());


        autherBookList.add(bookTemp);

        Book bookResult= bookRepository.save(bookTemp);

        return bookResult;
    }

    public Book getBookById(Integer bookId){
        Optional<Book> bookResult= bookRepository.findById(bookId);
        return bookResult.get();
    }

    public Auther getAutherByMaxWrittenPagesBook(){
        Integer autherId=bookRepository.findTopAuthorByPages();

        Optional<Auther> autherResult=autherRepository.findById(autherId);

        return autherResult.get();
    }


}
