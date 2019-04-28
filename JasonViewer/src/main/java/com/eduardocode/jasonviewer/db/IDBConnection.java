package com.eduardocode.jasonviewer.db;

import java.sql.Connection;
import java.sql.DriverManager;

// importando el paquete de constantes estaticas
import static com.eduardocode.jasonviewer.db.DatabaseMap.*;

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
	
	@SuppressWarnings("finally")
	default Connection connectToDB() {
		Connection connection = null;
		
		// estas constantes cargan debido al import static de la clase DatabaseMap
		String connectionURL = "jdbc:"+DRIVER+"://"+HOST+":"+PORT;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// usando la clase driver manager para ejecutar una conexion
			connection = DriverManager.getConnection(connectionURL, USER,
											PASSWORD);
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			return connection;
		}
	}
}
