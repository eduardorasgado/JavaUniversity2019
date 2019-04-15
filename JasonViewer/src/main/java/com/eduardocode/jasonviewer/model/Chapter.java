/**
 * 
 */
package com.eduardocode.jasonviewer.model;

import lombok.Data;

/**
 * Representa un capitulo que le pertenece a una serie
 * @author cheetos
 *
 */
@Data
public class Chapter extends Movie{
	private int id;
	private int seasonNumber;
	
	/**
	 * Implementacion y sobreescritura del metodo heredado de Movie para
	 * simular la visualizacion en este caso de un recurso
	 */
	@Override
	public void playResource() {
		// TODO Auto-generated method stub
		super.playResource();
	}
	
}
