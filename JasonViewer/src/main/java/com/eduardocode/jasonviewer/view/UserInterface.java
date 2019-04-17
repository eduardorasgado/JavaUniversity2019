/**
 * 
 */
package com.eduardocode.jasonviewer.view;

import java.util.Date;
import java.util.Scanner;

import com.eduardocode.jasonviewer.service.BookService;
import com.eduardocode.jasonviewer.service.ChapterService;
import com.eduardocode.jasonviewer.service.MovieService;
import com.eduardocode.jasonviewer.service.SerieService;

import lombok.Data;

/**
 * Clase que representa la interaccion directa con el usuario
 * @author cheetos
 *
 */
@Data
public class UserInterface {
	private Scanner sc = null;
	private boolean closeApp;
	
	private  MovieService movieService;
	private SerieService serieService;
	private ChapterService chapterService;
	private BookService bookService;
	
	// representa el limite superior para la validacion de la entrada del
	// menu principal
	private final int MAINMAXOPTION;
	
	public UserInterface(MovieService movieService,
							SerieService serieService, 
							ChapterService chapterService,
							BookService bookService, int mainmaxoption) {
		sc = new Scanner(System.in);
		this.closeApp = false;
		this.MAINMAXOPTION = mainmaxoption;
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
	 * Valida la opcion proporcionada por el usuario, asi mismo la devuelve si
	 * esta pasa la validacion
	 * @return
	 */
	private int getInputAndValidating() {
		while(true) {
			System.out.println("Escriba su opcion: ");
			try {
				int opcion = Integer.valueOf(sc.nextLine()); // lo que el usuario introduzca en la consola
				if(this.validatingMainMenuInput(opcion)) {
					return opcion;
				} else {
					this.showNotPassedValidationMessage();
				}
			} catch (NumberFormatException e) {
				this.showNotPassedValidationMessage();
			}
		}
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
	            System.out.println("viendo peliculas");
	        	//showMovies();
	            break;
	        case 2:
	        	System.out.println("viendo series");
	            //showSeries();
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
	
	// UTILITIES ---------------------------------
	
	/**
	 * valida si la entrada del usuario esta entre los limites numericos permitidos
	 * @param opcion
	 * @return
	 */
	private boolean validatingMainMenuInput(int opcion) {
		if(opcion >= 0 && opcion <= this.MAINMAXOPTION) {
			return true;
		}
		return false;
	}
	
	/**
	 * Muestra un mensaje de error generico
	 */
	private void showNotPassedValidationMessage() {
		System.out.println("Selecciona una opcion, tu opcion no es valida");
	}
}
