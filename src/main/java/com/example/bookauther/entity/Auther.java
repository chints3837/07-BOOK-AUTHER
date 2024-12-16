package com.example.bookauther.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.ManyToAny;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "auther")
public class Auther {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer aId;

    public String aName;

    public Integer aAge;

    public String aGender;

    @OneToMany(mappedBy = "auther", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Book> bookList = new ArrayList<>();
    // Initialize the list here

    public Auther(){

    }


    public Auther(Integer aId, String aName, Integer aAge, String aGender, List<Book> bookList) {
        this.aId = aId;
        this.aName = aName;
        this.aAge = aAge;
        this.aGender = aGender;
        this.bookList = bookList;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public Integer getaAge() {
        return aAge;
    }

    public void setaAge(Integer aAge) {
        this.aAge = aAge;
    }

    public String getaGender() {
        return aGender;
    }

    public void setaGender(String aGender) {
        this.aGender = aGender;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
