package com.eduardocode.jasonviewer.model;

import java.util.Date;

import lombok.Data;

@Data
public class Book extends Readable{
	
	private String isbn;
	private boolean read; // si el libro ha sido leido
	private int timeRead; // cuanto tiempo tomo leerlo
	
	public Book(String title, String genre, Date editionDate) {
		super(title, genre, editionDate);
	}

}
