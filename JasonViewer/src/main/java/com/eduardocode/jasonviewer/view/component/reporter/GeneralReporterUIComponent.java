/**
 * 
 */
package com.eduardocode.jasonviewer.view.component.reporter;

import java.util.ArrayList;

import com.eduardocode.jasonviewer.model.Book;
import com.eduardocode.jasonviewer.model.Movie;
import com.eduardocode.jasonviewer.model.Serie;

/**
 * Componente visual que representa la interaccion entre el usuario y la creacion
 * de reportes generales
 * @author cheetos
 *
 */
public class GeneralReporterUIComponent extends GenericReporterComponent {
	
	private ArrayList<Movie> movies = null;
	private ArrayList<Serie> series = null;
	private ArrayList<Book> books = null;
	
	public GeneralReporterUIComponent(int servicesQuantity) {
		this.maxOption = servicesQuantity;
	}
	
	/**
	 * Impresion en pantalla del menu general
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

	@Override
	protected void showMovieReport() {
		System.out.println("::REPORTE DE PELICULAS::");
		this.movies = this.movieService.getAll();
		
		for(int i = 0; i < this.movies.size();i++) {
			Movie movie = this.movies.get(i);
			System.out.print((i+1)+". Titulo: "+movie.getTitle());
			System.out.println(" | visto: "+movie.getIsViewed());
		}
		
	}

	@Override
	protected void showSerieReport() {
		System.out.println("::REPORTE DE SERIES::");
		this.series = serieService.getAll();
		
		for(int i = 0; i < this.series.size(); i++) {
			Serie serie = this.series.get(i);
			System.out.print((i+1)+". Titulo: "+serie.getTitle());
			System.out.println(" | visto: "+serie.getIsViewed());
		}
	}

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
