/**
 * 
 */
package com.eduardocode.jasonviewer.view;

import java.util.Date;

import com.eduardocode.jasonviewer.service.BookService;
import com.eduardocode.jasonviewer.service.ChapterService;
import com.eduardocode.jasonviewer.service.MovieService;
import com.eduardocode.jasonviewer.service.SerieService;
import com.eduardocode.jasonviewer.view.component.MoviesUIComponent;
import com.eduardocode.jasonviewer.view.component.SeriesUIComponent;

/**
 * Clase que representa la interaccion directa con el usuario
 * @author cheetos
 *
 */
public class UserInterface extends GenericViewComponent {
	// componentes de cada recurso
	MoviesUIComponent moviesUIComponent = null;
	SeriesUIComponent seriesUIComponent = null;
	
	private  MovieService movieService = null;
	private SerieService serieService = null;
	private BookService bookService = null;
	
	public UserInterface(MovieService movieService,
							SerieService serieService, 
							BookService bookService, int mainmaxoption) {
		
		// instanciando y configurando los componentes asociados
		this.moviesUIComponent = new MoviesUIComponent();
		this.moviesUIComponent.setService(movieService);
		this.seriesUIComponent = new SeriesUIComponent();
		this.seriesUIComponent.setService(serieService);
		
		// actualizando los servicios globales
		this.movieService = movieService;
		this.serieService = serieService;
		this.bookService = bookService;
		
		this.maxOption = mainmaxoption;
	}
	
	/**
	 * Muestra la lista de las posibles opciones que tiene el usuario para leer
	 * o ver
	 */
	private void showMenu() {
		System.out.println("\n[WELCOME TO JASON VIEWER]");
        System.out.println("");
        System.out.println("Selecciona la opcion a la que deseas accesar.");
        System.out.println("1. Movies");
        System.out.println("2. Series");
        System.out.println("3. Books");
        System.out.println("4. Magazines");
        System.out.println("5. Report");
        System.out.println("6. Report Today");
        System.out.println("0. Exit");
	}
	
	/**
	 * Loop principal de la aplicacion, se manda a llamar todo aquello que esta
	 * en la primera capa de menus, es decir seleccion de aquellos reproducibles
	 * por el usuario
	 */
	public void applicationLoop() {
		this.showMenu();
		int opcion = this.getInputAndValidating();
		
		if(opcion == 0) {
			System.out.println("Exelente dia, bye!");
			this.closeApp = true;
		}else {
			this.specificMenuSelector(opcion);
		}
	}
	
	/**
	 * Metodo para redireccionar del menu principal a uno de todos los menus para
	 * la seleccion del recurso que el usuario desee ver
	 */
	private void specificMenuSelector(int opcion) {	
		switch (opcion) {
	        case 1:
	        	// despliegue del menu de las peliculas
	        	moviesUIComponent.interact();
	        	// una vez saliendo de esto, los servicios son actualizados
	        	this.movieService = moviesUIComponent.getMovieService();
	            break;
	        case 2:
	        	seriesUIComponent.interact();
	        	this.serieService = seriesUIComponent.getSerieService();
	            break;
	        case 3:
	        	System.out.println("leyendo libros");
	            //showBooks();
	            break;
	        case 4:
	        	System.out.println("leyendo revistas");
	            //showMagazines();
	            break;
	        case 5:
	        	System.out.println("reporte...");
	            //makeReport();
	            break;
	        case 6:
	            Date today = new Date();
	            System.out.println("Reporte del dia "+today);
	            //makeReport(today);
	            break;
		}
	}
}
