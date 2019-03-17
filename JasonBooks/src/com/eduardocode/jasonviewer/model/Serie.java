package com.eduardocode.jasonviewer.model;

public class Serie extends Film {
    // attributes
    private int id;
    private int seasonQuantity;
    // chapter array
    private Chapter[] chapters;

    public Serie(String title, String genre, String director,
                 int duration, int seasonQuantity) {
        // father class
        super(title, genre, director, duration);
        // this class
        this.seasonQuantity = seasonQuantity;
    }

    @Override
    public String toString() {
        // overriding toString from Object inherited
        return "Title: "+getTitle() +
                "\nGenre: " + getGenre() +
                "\nYear: " + getYear() +
                "\nDirector: " + getDirector() +
                "\nDuration: " + getDuration() + " minutes";
    }

    // GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public int getSeasonQuantity() {
        return seasonQuantity;
    }

    public void setSeasonQuantity(int seasonQuantity) {
        this.seasonQuantity = seasonQuantity;
    }

    public Chapter[] getChapters() {
        return chapters;
    }

    public void setChapters(Chapter[] chapters) {
        this.chapters = chapters;
    }
}
