package com.eduardocode.jasonviewer;

import com.eduardocode.jasonviewer.db.DatabaseMap;
import com.eduardocode.jasonviewer.service.BookService;
import com.eduardocode.jasonviewer.service.MovieService;
import com.eduardocode.jasonviewer.service.SerieService;
import com.eduardocode.jasonviewer.view.UserInterface;

/**
 * <h1>Jason Viewer</h1>
 * Jason viewer es un programa que permite la visualizacion de peliculas, series,
 * libros y revistas on demand.
 * 
 * Permite generar reportes generales y reportes del dia.
 * 
 * <p>
 * Esta dividido en un patron de capas: capa de modelo, de negocio y de vista.
 * Se tienen modelos, repositorios, servicios de parte del backend. En el frontend
 * se maneja la modularidad a traves de componentes ui o visuales, por cada recurso
 * que la aplicacion maneja u ofrece al usuario.
 * 
 * @author cheetos(Eduardo Rasgado Ruiz)
 * @version 1.1
 * @since 2018
 *
 */

public class Main {
	public static void main(String[] args) {
		
		// creamos una instancia d eesta clase para cargar las propiedades
		// yaml con ayuda del propertyloader
		DatabaseMap dbm = new DatabaseMap();
		
		MovieService movieService = new MovieService();
		SerieService serieService = new SerieService();
		BookService bookService = new BookService();
		
		UserInterface ui = new UserInterface(
				movieService,
				serieService,
				bookService,
				6
				);
		while(true) {
			ui.applicationLoop();
			if(ui.isCloseApp()) {
				break;
			}
		}
	}
}
