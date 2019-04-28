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
 * @version 1.0
 * @since april/2019
 *
 */
public class DatabaseMap {
	// properties loader
	private static PropertiesLoader propertiesloader;
	
	
	// Env variables
	public static String DRIVER = "mysql";
	
	public static String HOST = "localhost";
	
	public static int PORT = 3306;
	
	public static String DB = "amazonviewer-admin";
	
	public static String USER;
	
	public static String PASSWORD;
	
	/**
	 * Metodo estatico que inicializa un property loader,
	 * este a su vez leera el archivo principal yaml del proyecto
	 * y al final se configuran las variables estaticas de esta clase
	 * 
	 * @see PropertiesLoader
	 */
	public static void readYamlProperties() {
		propertiesloader = new PropertiesLoader();
		
		// inicializacion de las variables estaticas
		PASSWORD = propertiesloader.getConfiguration()
				.getConnection()
				.getCredentials()
				.getPassword();
		
		USER = propertiesloader.getConfiguration()
				.getConnection()
				.getCredentials()
				.getUser();
		
		System.out.println(PASSWORD);
	}
	
}
