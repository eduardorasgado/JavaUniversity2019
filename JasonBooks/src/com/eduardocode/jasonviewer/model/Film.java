package com.eduardocode.jasonviewer.model;

public class Film {
    // Film is a super class

    private String title;
    private String genre;
    private String director;
    private int duration;
    private short year;
    private boolean viewed;

    protected Film(String title, String genre, String director, int duration) {
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.duration = duration;
    }

    // GETTERS AND SETTERS
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public boolean getViewed() {
        return viewed;
    }

    public void setViewed(boolean viewed) {
        this.viewed = viewed;
    }
}
