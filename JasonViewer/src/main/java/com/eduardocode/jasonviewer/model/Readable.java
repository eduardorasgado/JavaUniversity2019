package com.eduardocode.jasonviewer.model;

import java.util.ArrayList;
import java.util.Date;

import lombok.Data;

/**
 * <h1>Readable</h1>
 * 
 * Clase que representa el model del que heredan todas aquellas clases que se lean
 * 
 * @author cheetos
 * @version 1.1
 * @since 2019
 *
 */
@Data
public class Readable {
	private int id;
	private String title;
	private Date editionDate;
	private String genre;
	private String editorial;
	private ArrayList<String> authors;
	
	public Readable(String title, String genre, Date editionDate) {
		this.title = title;
		this.genre = genre;
		this.editionDate = editionDate;
	}
	
}
