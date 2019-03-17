package com.eduardocode.jasonviewer.model;

import java.util.Date;

public class Readable {
    private int id;
    private String title;
    private Date editionDate;
    private String genre;
    private String editorial;
    private String[] authors;

    protected Readable(String title, Date editionDate, String genre, String editorial) {
        this.title = title;
        this.editionDate = editionDate;
        this.genre = genre;
        this.editorial = editorial;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getEditionDate() {
        return editionDate;
    }

    public void setEditionDate(Date editionDate) {
        this.editionDate = editionDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }
}
