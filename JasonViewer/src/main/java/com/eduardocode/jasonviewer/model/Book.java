package com.eduardocode.jasonviewer.model;

import java.util.Date;

import lombok.Data;

/**
 * Representa un modelo de libro, extiende de readable
 * @author cheetos
 *
 */
@Data
public class Book extends Readable implements IReadable{
	
	private String isbn;
	private boolean read; // si el libro ha sido leido
	private int timeRead; // cuanto tiempo tomo leerlo
	
	public Book(String title, String genre, Date editionDate) {
		super(title, genre, editionDate);
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", read=" + read + ", getTitle()=" + getTitle() + ", getEditionDate()="
				+ getEditionDate() + ", getGenre()=" + getGenre() + "]";
	}

	@Override
	public Date startToSee(Date dateI) {
		// just a checking
        return dateI;
	}

	@Override
	public void stoptToSee(Date dateI, Date dateF) {
		int result = (dateF.getTime() > dateI.getTime())
                ? ((int)(dateF.getTime() - dateI.getTime()) / 1000) : 0;

        this.setTimeRead(result);
		
	}
	
	public String getIsRead() {
		return this.read ? "Si" : "No"; 
	}

}
