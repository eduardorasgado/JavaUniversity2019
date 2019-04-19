/**
 * 
 */
package com.eduardocode.jasonviewer.view.component.reporter;

import java.util.Date;

import com.eduardocode.jasonviewer.service.BookService;
import com.eduardocode.jasonviewer.service.MovieService;
import com.eduardocode.jasonviewer.service.SerieService;
import com.eduardocode.jasonviewer.view.GenericViewComponent;
import com.eduardocode.reportbuilder.model.Report;

import lombok.Data;

/**
 * <h1>GenericReporterComponent</h1>
 * Hereda de GenericViewComponent
 * <p>
 * Clase abstracta que permite derivar de ella reporteadores para la aplicacion
 * 
 * @author cheetos
 * @version 1.1
 * @since 2019
 */
@Data
public abstract class GenericReporterComponent extends GenericViewComponent {
	protected MovieService movieService = null;
	protected SerieService serieService = null;
	protected BookService bookService = null;
	protected Date reportDate = null;
	
	Report fileGenerator = null;
	
	public GenericReporterComponent() {
		this.fileGenerator = new Report();
		fileGenerator.setExtension("txt");
	}
	
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
	
	/**
	 * Genera un archivo con el contenido del reporte del recurso deseado por el
	 * usuario
	 * @param titulo
	 * @param nameFile Nombre del archivo
	 * @param content Contenido del cuerpo del archivo
	 */
	protected void generateReport(String titulo, String nameFile, String content) {
		fileGenerator.setTitle(titulo);
		
		fileGenerator.setNameFile(nameFile);
		
		fileGenerator.setContent(content);
		fileGenerator.buildReport();
		System.out.println("[El archivo de su reporte ha sido generado con exito]");
	}
}
