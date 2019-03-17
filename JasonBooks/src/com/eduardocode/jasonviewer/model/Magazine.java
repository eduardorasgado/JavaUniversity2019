package com.eduardocode.jasonviewer.model;

import java.util.Date;

public class Magazine extends Readable{
    private int id;
    private short number;

    public Magazine(String title, Date editionDate, String genre, String editorial, short number) {
        super(title,editionDate, genre, editorial);
        this.number = number;
    }

    @Override
    public String toString()
    {
        return "Magazine title: "+getTitle()+
                "\ngenre: "+getGenre();
    }

    // GETTERS AND SETTERS

    public short getNumber() {
        return number;
    }

    public void setNumber(short number) {
        this.number = number;
    }
}
