package com.example.jpaexample.demojpaexample;

import javax.persistence.*;

@Entity
@Table(name = "myBook")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "b_name")
    private String book_name;

    @Column(name = "aName")
    private String authorName;

    @Column(name = "cost")
    private int price;

    // AUTO INCREMENT FIELD
    public int getId() {
        return id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Book(String book_name, String authorName, int price) {
        this.book_name = book_name;
        this.authorName = authorName;
        this.price = price;
    }

    public Book(){

    }

    @Override
    public String toString(){
        return "book_name = " + this.getBook_name() + ", author_name = " + this.getAuthorName() + ", cost = " + this.getPrice();
    }

}
