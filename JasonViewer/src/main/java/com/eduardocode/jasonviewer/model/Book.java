package com.eduardocode.jasonviewer.model;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

/**
 * Representa un modelo de libro, extiende de readable
 * @author cheetos
 *
 */
@Data
public class Book extends Readable{
	
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
	
	

}
