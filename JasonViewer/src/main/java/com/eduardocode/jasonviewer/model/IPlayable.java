/**
 * 
 */
package com.eduardocode.jasonviewer.model;

import java.util.Date;

/**
 * <h1>IPlayable</h1>
 * Interfaz que permite representar inicio y fin de la visualizacion de una
 * pelicula
 * 
 * @author cheetos
 * @version 1.1
 * @since 2019
 *
 */
public interface IPlayable {
	
	/**
	 * Facilita la obtencion de un tiempo determinado en el momento en que
	 * el metodo es llamado
	 * de un recurso
	 * 
	 * @param dateI Es un objeto {@code Date} con el tiempo de inicio exacto
	 * @return Devuelve al fecha y hora capturada
	 */
	Date startToSee(Date dateI);
	
	/**
	 * Facilita las operaciones que requieran del tiempo de inicio y tiempo
	 * final de la visualizacion de un rescurso
	 * 
	 * @param dateI Es hora de ingreso
	 * @param dateF Es hora final o de salida
	 */
	void stopToSee(Date dateI, Date dateF);
}
