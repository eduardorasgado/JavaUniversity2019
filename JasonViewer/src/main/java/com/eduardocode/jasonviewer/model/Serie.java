/**
 * 
 */
package com.eduardocode.jasonviewer.model;

import java.util.Set;

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
	private Set<Chapter> chapters;

	@Override
	public void playResource() {
		// TODO Auto-generated method stub		
	}
}
