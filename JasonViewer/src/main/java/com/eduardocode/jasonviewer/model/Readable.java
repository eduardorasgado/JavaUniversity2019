package com.eduardocode.jasonviewer.model;

import java.util.ArrayList;
import java.util.Date;

import lombok.Data;

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
