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
	
}
