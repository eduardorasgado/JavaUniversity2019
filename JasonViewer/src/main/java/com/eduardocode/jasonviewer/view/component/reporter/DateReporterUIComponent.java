/**
 * 
 */
package com.eduardocode.jasonviewer.view.component.reporter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.eduardocode.jasonviewer.model.Book;
import com.eduardocode.jasonviewer.model.Movie;
import com.eduardocode.jasonviewer.model.Serie;

/**
 * @author Eduardo Rasgado Ruiz
 *
 */
public class DateReporterUIComponent extends GenericReporterComponent {
	
	private ArrayList<Movie> movies = null;
	private ArrayList<Serie> series = null;
	private ArrayList<Book> books = null;
	private SimpleDateFormat formatter;
	private SimpleDateFormat formatterForFileName;
	
	public DateReporterUIComponent(int q) {
		this.maxOption = q;
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		formatterForFileName = new SimpleDateFormat("dd-MM-yyyy");
	}
	
	@Override
	protected void showMainMenu() {
		System.out.println("::TODAY REPORTER, DATE: "
							+this.formatter.format(reportDate)+"::");
		System.out.println("1. Reporte de peliculas");
		System.out.println("2. Reporte de series");
		System.out.println("3. Reporte de libros");
		System.out.println("0. Salir");
		
	}

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
					+ "correcta funcion del reporter");
		}
		
		
	}

	@Override
	protected void showMovieReport() {
		String content = "";
		
		System.out.println("::REPORTE DE PELICULAS::");
		this.movies = this.movieService.readWithDate(this.reportDate);
		
		for(int i = 0; i < this.movies.size();i++) {
			Movie movie = this.movies.get(i);
			String movieLine = (i+1)+". Titulo: "+movie.getTitle()
								+" | visto: "+movie.getIsViewed();
			System.out.println(movieLine);
			content += movieLine+"\n";
		}
		// generando el reporte
		String stringDate = this.formatterForFileName.format(reportDate);
		this.generateReport("::REPORTE DE PELICULAS DEL DIA "
				+stringDate+"::", 
				"reporte_de_peliculas-"+stringDate, content);		
	}

	@Override
	protected void showSerieReport() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void showBookReport() {
		// TODO Auto-generated method stub
		
	}
	
	public void setDate(Date date) {
		this.reportDate = date; 
	}

}
