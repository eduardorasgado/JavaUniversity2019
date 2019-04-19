/**
 * 
 */
package com.eduardocode.jasonviewer.view.component.reporter;

import java.util.ArrayList;

import com.eduardocode.jasonviewer.model.Book;
import com.eduardocode.jasonviewer.model.Movie;
import com.eduardocode.jasonviewer.model.Serie;
import com.eduardocode.reportbuilder.model.Report;

/**
 * <h1>GeneralReporterUIComponent</h1>
 * Componente visual que representa la interaccion entre el usuario y la creacion
 * de reportes generales
 * @author cheetos
 * @version 1.1
 * @since 2019
 *
 */
public class GeneralReporterUIComponent extends GenericReporterComponent {
	
	private ArrayList<Movie> movies = null;
	private ArrayList<Serie> series = null;
	private ArrayList<Book> books = null;
	
	Report fileGenerator = null;
	
	public GeneralReporterUIComponent(int servicesQuantity) {
		this.maxOption = servicesQuantity;
		this.fileGenerator = new Report();
	}
	
	/**
	 * Impresion en pantalla del menu general
	 * <p>
	 * Metodo que permite al usuario visualizar en pantalla los posibles tipos
	 * de reporte que puede elaborar
	 */
	@Override
	protected void showMainMenu() {
		System.out.println("::GENERAL REPORTER::");
		System.out.println("1. Reporte de peliculas");
		System.out.println("2. Reporte de series");
		System.out.println("3. Reporte de libros");
		System.out.println("0. Salir");
	}

	/**
	 * loop o logica principal para la interaccion entre el reporter y el usuario
	 */
	@Override
	public void interact() {
		if((movieService !=null) && (serieService != null) && (bookService != null)) {
			while(true) {
				this.showMainMenu();
				int option = this.getInputAndValidating();
				if(option == 0) {
					System.out.println("Saliendo al menu principal...");
					break;
				} else {
					// impresion de reporter dada la opcion elegida por el usuario
					// implementado en genericreportercomponent
					this.runResourceReport(option);
					System.out.println("\n");
				}
			}
		} else {
			System.out.println("Uno o mas servicios no han sido configurados para la"
					+ "correcta función del reporter");
		}
	}

	/**
	 * Muestra el reporte de las peliculas en la aplicacion.
	 * Genera un archivo de reporte con los datos detallados de este para el caso
	 * de las peliculas
	 */
	@Override
	protected void showMovieReport() {
		fileGenerator.setTitle("::REPORTE DE PELICULAS::");
		fileGenerator.setExtension("txt");
		fileGenerator.setNameFile("reporte_general");
		String content = "";
		
		System.out.println("::REPORTE DE PELICULAS::");
		this.movies = this.movieService.getAll();
		
		for(int i = 0; i < this.movies.size();i++) {
			Movie movie = this.movies.get(i);
			String movieLine = (i+1)+". Titulo: "+movie.getTitle()
								+" | visto: "+movie.getIsViewed();
			System.out.println(movieLine);
			content += movieLine+"\n";
		}
		fileGenerator.setContent(content);
		fileGenerator.buildReport();
		System.out.println("[El archivo de su reporte ha sido generado con exito]");
	}

	/**
	 * Mostrando el reporte de cada una de las series asi como de los capitulos
	 * vistos por cada serie
	 */
	@Override
	protected void showSerieReport() {
		System.out.println("::REPORTE DE SERIES::");
		this.series = serieService.getAll();
		
		for(int i = 0; i < this.series.size(); i++) {
			Serie serie = this.series.get(i);
			System.out.print((i+1)+". Titulo: "+serie.getTitle());
			System.out.print(" | capitulos totales vistos: "
						+ this.serieService.chaptersViewbySerie(i)+"/"
						+ serie.getChapters().size());
			System.out.println(" | visto: "+serie.getIsViewed());
		}
	}

	/**
	 * Muestra el reporte de los libros de la aplicacion
	 */
	@Override
	protected void showBookReport() {
		System.out.println("::REPORTE DE LIBROS::");
		this.books = bookService.getAll();
		
		for(int i = 0; i < this.books.size(); i++) {
			Book book = this.books.get(i);
			System.out.print((i+1)+". Titulo: "+book.getTitle());
			System.out.println(" | leido: "+book.getIsRead());
		}
	}

}
