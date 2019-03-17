package com.eduardocode.jasonviewer.model;

import java.util.Date;

public class Book extends Readable {
    // attributes
    private String isbn;
    // if book has been read
    private boolean read;
    // how much time do this book was read
    private int timeRead;

    public Book(String title, Date editionDate, String genre, String editorial, String isbn) {
        super(title,editionDate,genre,editorial);
        this.isbn = isbn;
    }
    // to string
    @Override
    public String toString()
    {
        return "Book Title: "+getTitle()+
                "\ngenre: "+getGenre();
    }

    // GETTERS AND SETTERS
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public int getTimeRead() {
        return timeRead;
    }

    public void setTimeRead(int timeRead) {
        this.timeRead = timeRead;
    }
}
