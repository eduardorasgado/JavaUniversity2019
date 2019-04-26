package com.eduardocode.jasonviewer.model;

import java.util.Date;

import lombok.Data;

/**
 * <h1>Book</h1>
 * Clase que hereda de Readable y que implementa la interfaz IReadable.
 * <p>
 * Representa un modelo de libro, extiende de readable
 * 
 * @author cheetos
 * @version 1.1
 * @since 2019
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

	/**
	 * Sobreescritura del metodo toString para poder hacer debugging
	 */
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", read=" + read + ", getTitle()=" + getTitle() + ", getEditionDate()="
				+ getEditionDate() + ", getGenre()=" + getGenre() + "]";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Date startToSee(Date dateI) {
		// just a checking
        return dateI;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stoptToSee(Date dateI, Date dateF) {
		int result = (dateF.getTime() > dateI.getTime())
                ? ((int)(dateF.getTime() - dateI.getTime()) / 1000) : 0;

        this.setTimeRead(result);
		
	}
	
	/**
	 * Metodo que devuelve si un libro ha sido ya leido o no por un usuario
	 * @return Devuelve un objeto string con un si o un no
	 */
	public String getIsRead() {
		return this.read ? "Si" : "No"; 
	}

}
