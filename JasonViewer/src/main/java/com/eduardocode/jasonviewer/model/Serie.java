/**
 * 
 */
package com.eduardocode.jasonviewer.model;

import java.util.ArrayList;

import lombok.Data;

/**
 * Representacion de una serie dentro de la aplicacion
 * Una serie posee capitulos
 * @author cheetos
 *
 */
@Data
public class Serie extends Watchable {
	
	private int id;
	private int seasonQuantity;
	private ArrayList<Chapter> chapters;

	@Override
	public void playResource() {
		this.chapters = new ArrayList<Chapter>();		
	}
}
