package com.example.bookauther.repository;

import com.example.bookauther.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {


    @Query(value = "SELECT auth_id FROM book b GROUP BY auth_id ORDER BY SUM(b_pages) DESC LIMIT 1", nativeQuery = true)
    Integer findTopAuthorByPages();
}
