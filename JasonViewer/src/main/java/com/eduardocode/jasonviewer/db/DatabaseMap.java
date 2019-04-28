/**
 * 
 */
package com.eduardocode.jasonviewer.db;

import com.eduardocode.jasonviewer.utils.PropertiesLoader;

/**
 * <h1>DatabaseMap</h1>
 * Clase que representa a una clase de constantes, sera una abstraccion de
 * conceptios que involucran una coneccion a la base de datos
 * @author Eduardo Rasgado Ruiz
 *
 */
public class DatabaseMap {
	// properties loader
	private PropertiesLoader propertiesloader;
	
	
	// Env variables
	public static final String DRIVER = "mysql";
	
	public static final String HOST = "localhost";
	
	public static final int PORT = 3306;
	
	public static final String DB = "amazonviewer-admin";
	
	public static final String USER = "amazonviewer-admin";
	
	public static final String PASSWORD = "Red$ew75vPBqAV4z";
	
	public DatabaseMap() {
		propertiesloader = new PropertiesLoader();
		System.out.println(propertiesloader.getEnvPassword());
	}
	
}
