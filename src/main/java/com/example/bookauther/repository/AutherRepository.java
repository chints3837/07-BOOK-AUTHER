package com.example.bookauther.repository;

import com.example.bookauther.entity.Auther;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AutherRepository extends JpaRepository<Auther,Integer> {

    @Query(
            value = "SELECT COUNT(*) " +
                    "FROM book b " +
                    "JOIN publication p ON b.b_id = p.b_id " +
                    "WHERE b.auth_id = :authId " +
                    "AND p.year_of_publication = :yearOfPublication",
            nativeQuery = true
    )
    int countBooksByAuthorAndYear(@Param("authId") Integer authId, @Param("yearOfPublication") String yearOfPublication);
}
