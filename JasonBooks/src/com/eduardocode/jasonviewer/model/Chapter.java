package com.eduardocode.jasonviewer.model;

public class Chapter extends Movie {
    // attributes
    private int id;
    private int seasonNumber;

    public Chapter(String title, String genre, String director,
                   int duration, short year, int seasonNumber) {
        super(title, genre, director, duration, year);
        this.seasonNumber = seasonNumber;
    }

    @Override
    public String toString()
    {
        return "Title: "+getTitle() +
                "\nGenre: " + getGenre() +
                "\nYear: " + getYear() +
                "\nDirector: " + getDirector() +
                "\nDuration: " + getDuration() + " minutes";
    }

    // GETTERS AND SETTERS
    @Override
    public int getId() {
        // iverloading the father id and returning the
        // actual chapter object id
        return this.id;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }
}
