package com.eduardocode.jasonviewer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.eduardocode.jasonviewer.db.IDBConnection;
import com.eduardocode.jasonviewer.model.Movie;

import static com.eduardocode.jasonviewer.db.MovieMap.*;
import static com.eduardocode.jasonviewer.db.ViewMap.*;
import static com.eduardocode.jasonviewer.db.MaterialMap.*;

/**
 * <h1>MovieDAO</h1>
 * Interfaz que ofrece un acceso a datos para el modelo de pelicula
 * 
 * <p>
 * 
 * Usaremos interfaces para implementar métodos que se comporten entre familias. 
 * Es decir la relación que va más allá de la herencia entre dos clases.
 * 
 * Enfocado a acciones:
 * 	Drawable
 * 	Runnable
 * 	Callable
 * 	Visualizable
 * 
 * Usaremos clases abstractas para definir subclases, esta siempre deberá ser 
 * heredada para poder utilizar y sobre escribir métodos de la clase padre.
 * 
 * Enfocado a objetos:
 * 	Film
 * 	Persona
 * 	Empleado
 * 	Figure
 * 	Publication
 * 
 * Recomendaciones al hacer abstracciones:
 * 	Enfocarse en crear interfaces y no en la implementacion
 * 	Esto es:
 * 		Crear buenas abstracciones
 * 		Comportamiento común
 * 		Declaración de métodos
 * 
 * @author Eduardo Rasgado Ruiz
 *
 */
public interface MovieDAO extends IDBConnection {

	/**
	 * Metodo para introducir una pelicula en la clase que implemente la 
	 * interface movie dao
	 * @param movie
	 * @return
	 */
	default void setMovieView(Movie movie) {
		String query = "INSERT INTO "+TVIEWED+" ("+TVIEWED_ID_MATERIAL+","
						+TVIEWED_ID_ELEMENT+","
						+TVIEWED_ID_USER+","
						+TVIEWED_CREATED_AT+") VALUES (?, ?, ?, ?)";
		
		try(Connection connection = this.connectToDB()) {
			PreparedStatement preparedStatement = null;
			
			// verificar que la pelicula aun no este registrada en las vistas
			// si ya fue vista no se ejecuta la query
			if(!this.getMovieView(preparedStatement, connection, movie.getId())) {
				// se busca primero el id del material movie
				int tmovie_material_id = getMovieViewedIdInMaterialTable(preparedStatement,
						connection);
				
				preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setInt(1, tmovie_material_id);
				preparedStatement.setInt(2, movie.getId());
				// user id hardcodeado
				preparedStatement.setInt(3, 1);
				// insertando la fecha de hoy
				preparedStatement.setDate(4, new java.sql.Date(new Date().getTime()));

				// insertando la fila con la pelicula vista
				preparedStatement.execute();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Retorna una lista de peliculas
	 * @return
	 */
	default ArrayList<Movie> read() {
		ArrayList<Movie> movies = new ArrayList<Movie>();
		
		String query = "SELECT * FROM "+TMOVIE+";";
		
		// creando una conexion a la base de datos con la funcion de la clase
		// IDBConnection
		try(Connection connection= this.connectToDB()){
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				// revisando fila por fila de los datos traidos de la db
				// llenando el arreglo de peliculas con los datos de la busqueda
				Movie movie = new Movie(
						rs.getString(TMOVIE_TITLE),
						rs.getString(TMOVIE_GENRE),
						rs.getString(TMOVIE_CREATOR),
						Integer.valueOf(rs.getString(TMOVIE_DURATION)),
						Short.valueOf(rs.getString(TMOVIE_YEAR))
						);
				int idDB = Integer.valueOf(rs.getString(TMOVIE_ID));
				movie.setId(idDB);
				
				movie.setViewed(this.getMovieView(preparedStatement, connection, idDB));
				
				movies.add(movie);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movies;
	}
	
	/**
	 * Metodo que busca una pelicula dentro de la base de datos con un id
	 * especifico
	 * @param id identificador de la pelicula deseada
	 * @return Una pelicula
	 */
	default Movie get(int id) {
		Movie movie = new Movie();
		
		String query = "SELECT * FROM "+TMOVIE+" WHERE "
								+TMOVIE_ID+" = ?";
		
		try(Connection connection = this.connectToDB()) {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				movie.setId(Integer.valueOf(rs.getString(TMOVIE_ID)));
				movie.setTitle(rs.getString(TMOVIE_TITLE));
				movie.setGenre(rs.getString(TMOVIE_GENRE));
				movie.setDirector(rs.getString(TMOVIE_CREATOR));
				movie.setYear(Short.valueOf(rs.getString(TMOVIE_YEAR)));
				movie.setViewed(this.getMovieView(preparedStatement, 
								connection, movie.getId()));
			}
			return movie;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		// en caso de que no exista la pelicula
		return null;
	}
	
	// en java 9 en adelante es posible crear metodos private en interfaces
	//private void doSomething();
	
	/**
	 * Metodo default para comprobar de la base de datos si una pelicula ya
	 * fue vista por un determinado usuario
	 * @param preparedStatement query builder
	 * @param connection conexion a la base de datos
	 * @param id identificador del usuario
	 * @return si la pelicula ya fue vista o no
	 */
	default boolean getMovieView(PreparedStatement preparedStatement,
			Connection connection, int id) {
		
		// flag para confirmar que existe una pelicula vista con el id
		boolean viewed = false;
		
		int movieIdMaterial = this.getMovieViewedIdInMaterialTable(preparedStatement,
				connection);
		// id de usuario hardcodeado
		int userId = 1;
		
		String query = "SELECT * FROM " + TVIEWED +
				" WHERE " + TVIEWED_ID_MATERIAL + " = ?"
				+" AND "+TVIEWED_ID_ELEMENT+" = ?"
				+" AND "+TVIEWED_ID_USER+" = ?";
		
		ResultSet rs = null;
		try {
			// en caso de que no exista movies en material table
			if(movieIdMaterial == -1) {
				System.out.println("No existe el materia "
								+TMOVIE+" en la tabla "+TMATERIAL);
				throw new SQLException();
			}
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, movieIdMaterial);
			preparedStatement.setInt(2, id);
			preparedStatement.setInt(3, userId);
			
			rs = preparedStatement.executeQuery();
			
			// si existe un elemento en la tabla entonces regresa una vista
			viewed = rs.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return viewed;
	}
	
	/**
	 * Metodo que devuelve una lista de peliculas vistas en una fecha determinada
	 * Primero busca en la tabla viewed los ids de las peliculas y fecha
	 * y luego busca estas peliculas en la tabla movie y las devuelve juntas
	 * @param date fecha de busqueda
	 * @return lista de peliculas vistas en la fecha determinada
	 */
	default ArrayList<Movie> readWithDate(Date date) {
		// donde guardar los indices de las peliculas que cunmplen con la fecha
		ArrayList<Integer> moviesIds = new ArrayList<Integer>();
		// las peliculas a regresar
		ArrayList<Movie> movies = new ArrayList<Movie>();
		
		String query = "SELECT * FROM "+TVIEWED+" WHERE "+
				TVIEWED_ID_MATERIAL+" = ? AND "+
				TVIEWED_CREATED_AT+" =?";
		
		PreparedStatement ps = null;
		
		try(Connection connection = this.connectToDB()){
			
			ps = connection.prepareStatement(query);
			// el id de movie en la columna material
			ps.setInt(1, getMovieViewedIdInMaterialTable(ps, connection));
			// la fecha deseada
			ps.setDate(2, new java.sql.Date(date.getTime()));
			
			ResultSet rs = ps.executeQuery();
			// se llena la lista de los indices de las movies
			while(rs.next()) {
				moviesIds.add(new Integer(
								Integer.valueOf(
											rs.getString(TVIEWED_ID_ELEMENT)
										)
							));
			}
			
			// ahora se buscan esas movies
			for(Integer id : moviesIds) {
				Movie movie = this.get(id);
				movies.add(movie);
			}
			
			return movies;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movies;
	}
	
	/**
	 * Metodo que busca dentro de la tabla material, el identificador de
	 * el material "movie"
	 * @return el id de el material movie
	 */
	default int getMovieViewedIdInMaterialTable(PreparedStatement preparedStatement,
			Connection connection) {
		String query = "SELECT * FROM "+TMATERIAL + " WHERE "
				+ TMATERIAL_NAME + " = ?";
		
		try {
			preparedStatement = connection
					.prepareStatement(query);
			preparedStatement.setString(1, TMOVIE);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				int tmovie_material_id = Integer.valueOf(rs.getString(TMATERIAL_ID));
				return tmovie_material_id;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
