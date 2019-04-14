/**
 * 
 */
package com.eduardocode.jasonviewer.model;

import lombok.Data;

/**
 * Clase abstracta que representa tres clases hijas: serie, chapter y movie
 * @author cheetos
 *
 */

@Data
public abstract class Watchable {
	private String title;
	private String genre;
	private String director;
	private int duration;
	private short year;
	private boolean viewed;
	
	public String getIsViewed() {
		String isViewed = (viewed) ? "Si" : "No";
		return isViewed;
	}
	
	public abstract void playResource();
}
