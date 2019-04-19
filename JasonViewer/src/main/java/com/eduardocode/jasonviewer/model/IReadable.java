/**
 * 
 */
package com.eduardocode.jasonviewer.model;

import java.util.Date;

/**
 * <h1>IReadable</h1>
 * 
 * Interfaz que representa un patron util para los modelos que sean de lectura
 * @author cheetos
 * @version 1.1
 * @since 2019
 *
 */
public interface IReadable {
	/**
	 * Metodo que permite crear una logica para la captacion de una fecha de 
	 * ingreso o entrada
	 * @param dateI Fecha de ingreso
	 * @return Devuelve una fecha exacta
	 */
	Date startToSee(Date dateI);
	
	/**
	 * Metodo que permite crear una logica para determinar el tiempo total que
	 * toma la lectura de un readable a partir de una fecha de ingreso y una 
	 * fecha de cierre
	 * @param dateI Fecha de ingreso
	 * @param dateF Fecha de cierre
	 */
    void stoptToSee(Date dateI, Date dateF);
}
