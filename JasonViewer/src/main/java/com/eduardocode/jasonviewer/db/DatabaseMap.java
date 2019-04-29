/**
 * 
 */
package com.eduardocode.jasonviewer.db;

import com.eduardocode.jasonviewer.db.configuration.vo.Configuration;
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
	
	public static String DRIVER_PACKAGE;
	
	public static String DRIVER_ALIAS;
	
	public static String HOST;
	
	public static int PORT;
	
	public static String DB;
	
	public static String USER;
	
	public static String PASSWORD;
	
	public static String LOCAL_TIMEZONE;
	
	/**
	 * Metodo estatico que inicializa un property loader,
	 * este a su vez leera el archivo principal yaml del proyecto
	 * y al final se configuran las variables estaticas de esta clase
	 * 
	 * @see PropertiesLoader
	 */
	public static void readYamlProperties() {
		propertiesloader = new PropertiesLoader();
		
		Configuration config = propertiesloader.getConfiguration();
		
		// inicializacion de las variables estaticas
		
		DRIVER_PACKAGE = config
				.getConnection()
				.getDriver()
				.getPackageDir();
		
		DRIVER_ALIAS = config
				.getConnection()
				.getDriver()
				.getDbengine();
		
		HOST = config
				.getConnection()
				.getHost();
		
		PORT = config
				.getConnection()
				.getPort();
		
		DB = config
				.getConnection()
				.getDb();
		
		PASSWORD = config
				.getConnection()
				.getCredentials()
				.getPassword();
		
		USER = config
				.getConnection()
				.getCredentials()
				.getUser();
		
		LOCAL_TIMEZONE = config
				.getConnection()
				.getLocalTimezone();
	}
	
}
