package com.example.bookauther.serviceImpl;

import com.example.bookauther.entity.Book;
import com.example.bookauther.entity.Publication;
import com.example.bookauther.repository.BookRepository;
import com.example.bookauther.repository.PublicationRepository;
import com.example.bookauther.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PublicationServiceImpl implements PublicationService {

    @Autowired
    private PublicationRepository publicationRepository;

    @Autowired
    private BookRepository bookRepository;


    public Publication savePublication(Publication publication,Integer bookId){

        Optional<Book> bookTemp=bookRepository.findById(bookId);

        Publication publicationTemp=new Publication();
        publicationTemp.setYearOfPublication(publication.getYearOfPublication());
        publicationTemp.setpName(publication.getpName());
        bookTemp.get().getBookPublishList().add(publicationTemp);


        Book bookResult= bookRepository.save(bookTemp.get());

        return bookResult.getBookPublishList().get(bookResult.getBookPublishList().size()-1);
    }
}
