/**
 * 
 */
package com.eduardocode.jasonviewer.model;

import java.util.Date;

/**
 * Interfaz que permite representar inicio y fin de la visualizacion de una
 * pelicula
 * @author cheetos
 *
 */
public interface IPlayable {
	
	Date startToSee(Date dateI);
	
	void stopToSee(Date dateI, Date dateF);
}
