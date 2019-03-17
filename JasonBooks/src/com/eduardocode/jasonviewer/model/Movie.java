package com.eduardocode.jasonviewer.model;

import java.util.Date;

// Java classes can have as many interfaces as you need
// but it is not the case for class inheritance
public class Movie extends Film implements IPlayable {
    // Movie is a subclass

    // declaring attributes
    // usually these data is private and they need
    // setters and getters to be accessed
    private int id;
    private int timeViewed;

    // constructor considering Film class inherited
    public Movie(String title, String genre, String director, int duration, short year) {
        // super takes the values when the class Movie is instantiated
        // and set them to Film class
        super(title, genre, director, duration);
        this.setYear(year);
    }

    // overriding methods from a super class
    @Override
    public String toString()
    {
        // overriding toString from Object
        return "Title: "+getTitle() +
                "\nGenre: " + getGenre() +
                "\nYear: " + getYear() +
                "\nDirector: " + getDirector() +
                "\nDuration: " + getDuration() + " minutes";
    }

    // overriding IPlayable methods
    @Override
    public Date startToSee(Date dateI)
    {
        // just a checking
        return dateI;
    }

    @Override
    public void stoptToSee(Date dateI, Date dateF) {
        long result = (dateF.getTime() > dateI.getTime())
                ? (dateF.getTime() - dateI.getTime() / 1000) : 0;

        this.setTimeViewed((int)result);
    }

    //  SETTERS AND GETTERS
    public int getId() {
        return id;
    }

    public int getTimeViewed() {
        return timeViewed;
    }

    public void setTimeViewed(int timeViewed) {
        this.timeViewed = timeViewed;
    }

}

