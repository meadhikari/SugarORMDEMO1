package com.bigfootsoftwares.sugarormdemo1;

import com.orm.SugarRecord;
import com.orm.dsl.Column;
import com.orm.dsl.Table;

@Table(name = "Book")
public class Book{

    @Column(name = "bookId", unique = true, notNull = true)
    private int bookId;
    String title;
    String edition;

    public Book(){

    }

    public Book(int bookId,String title, String edition){
        this.bookId = bookId;
        this.title = title;
        this.edition = edition;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }
    @Override
    public String toString() {
        return title + "id: " + bookId;

    }
}