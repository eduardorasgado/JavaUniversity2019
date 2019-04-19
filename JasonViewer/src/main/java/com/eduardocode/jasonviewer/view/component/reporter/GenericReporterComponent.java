/**
 * 
 */
package com.eduardocode.jasonviewer.view.component.reporter;

import java.util.Date;

import com.eduardocode.jasonviewer.service.BookService;
import com.eduardocode.jasonviewer.service.MovieService;
import com.eduardocode.jasonviewer.service.SerieService;
import com.eduardocode.jasonviewer.view.GenericViewComponent;

import lombok.Data;

/**
 * Clase abstracta que permite derivar de ella reporteadores para la aplicacion
 * @author cheetos
 *
 */
@Data
public abstract class GenericReporterComponent extends GenericViewComponent {
	protected MovieService movieService = null;
	protected SerieService serieService = null;
	protected BookService bookService = null;
	protected Date reportDate = null;
	
	/**
	 * Metodo para imprimir el menu principal del reporter
	 */
	protected abstract void showMainMenu();
	
	/**
	 * Metodo para poder implementar el loop de impresion en pantalla y
	 * la validacion y aplicacion de la seleccion del usuario
	 */
	public abstract void interact();
	
	/**
	 * Metodo que imprime el reporte de peliculas
	 */
	protected abstract void showMovieReport();
	
	/**
	 * Metodo que imprimer el reporte de series
	 */
	protected abstract void showSerieReport();
	
	/**
	 * Metodo que imprime el reporte de libros
	 */
	protected abstract void showBookReport();
	
	/**
	 * Metodo que dada la seleccion de el usuario, ejecuta el reporter
	 * determinado
	 * @param option
	 */
	protected void runResourceReport(int option) {
		switch (option) {
		case 1:
			this.showMovieReport();
			break;
		case 2:
			this.showSerieReport();
			break;
		case 3:
			this.showBookReport();
			break;

		default:
			break;
		}
	}
}
