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
	
	/**
	 * Facilita la obtencion de un tiempo determinado en el momento en que
	 * el metodo es llamado
	 * de un recurso
	 * @param dateI
	 * @return
	 */
	Date startToSee(Date dateI);
	
	/**
	 * Facilita las operaciones que requieran del tiempo de inicio y tiempo
	 * final de la visualizacion de un rescurso
	 * @param dateI
	 * @param dateF
	 */
	void stopToSee(Date dateI, Date dateF);
}
