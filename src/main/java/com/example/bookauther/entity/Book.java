package com.example.bookauther.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer bId;

    public String bName;

    public Integer bPages;

    @ManyToOne
    @JoinColumn(name = "auth_id")
    @JsonBackReference
    public Auther auther;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "bId")
    private List<Publication> bookPublishList = new ArrayList<>();

    public Book() {
    }

    public Book(Integer bId, String bName, Integer bPages, Auther auther, List<Publication> bookPublishList) {
        this.bId = bId;
        this.bName = bName;
        this.bPages = bPages;
        this.auther = auther;
        this.bookPublishList = bookPublishList;
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public Integer getbPages() {
        return bPages;
    }

    public void setbPages(Integer bPages) {
        this.bPages = bPages;
    }

    public Auther getAuther() {
        return auther;
    }

    public void setAuther(Auther auther) {
        this.auther = auther;
    }

    public List<Publication> getBookPublishList() {
        return bookPublishList;
    }

    public void setBookPublishList(List<Publication> bookPublishList) {
        this.bookPublishList = bookPublishList;
    }
}
