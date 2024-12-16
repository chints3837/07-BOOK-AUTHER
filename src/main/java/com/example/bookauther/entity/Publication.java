package com.example.bookauther.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer pId;

    public String pName;

    public String yearOfPublication;

//    @ManyToOne
//    @JoinColumn(name = "bId")
//    public Book book;

    public Publication() {
    }

    public Publication(Integer pId, String pName, String yearOfPublication) {
        this.pId = pId;
        this.pName = pName;
        this.yearOfPublication = yearOfPublication;
//        this.book = book;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(String yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

//    public Book getBook() {
//        return book;
//    }
//
//    public void setBook(Book book) {
//        this.book = book;
//    }
}
