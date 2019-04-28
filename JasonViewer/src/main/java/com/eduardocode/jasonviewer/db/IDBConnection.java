package com.eduardocode.jasonviewer.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Clase para realizar la coneccion entre la capa de modelo y la base de datos
 * externa que se esta ocupando para la aplicacion
 * 
 * @author Eduardo Rasgado Ruiz
 * @version 1.0
 * @since april/2019
 *
 */
public interface IDBConnection {
	
	default Connection connectToDB(String host, String port) {
		
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// usando la clase driver manager para ejecutar una conexion
			connection = DriverManager.getConnection("")
		} catch() {
			
		}
		finally {
			
		}
		return connection;
	}

}
