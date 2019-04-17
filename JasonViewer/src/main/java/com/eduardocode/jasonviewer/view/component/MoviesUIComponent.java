/**
 * 
 */
package com.eduardocode.jasonviewer.view.component;

import java.util.Scanner;

import com.eduardocode.jasonviewer.model.Movie;
import com.eduardocode.jasonviewer.service.MovieService;
import com.eduardocode.jasonviewer.view.GenericViewComponent;

import lombok.Data;

/**
 * Representa un componente de interaccion entre el usuario y las peliculas, su
 * visualizacion, etc
 * @author cheetos
 *
 */
@Data
public class MoviesUIComponent extends GenericViewComponent implements IFrontComponent<Movie, MovieService> {
	
	private MovieService movieService = null;
	
	public MoviesUIComponent() {
	}
	
	/**
	 * Previo a la operacion del componente ui de peliculas, debe de configurarse
	 * el servicio al que se conecta
	 * @param movieService
	 */
	@Override
	public void setService(MovieService movieService) {
		this.movieService = movieService;
		// para tener el maximo al momento de tomar el input del usuario
		this.maxOption = movieService.getAll().size();
	}
	
	/**
	 * Muestra visual de todas las peliculas con las que la aplicacion cuenta
	 */
	@Override
	public void showMenu() {
		System.out.println("::MOVIES::");
        
        for(int i = 0; i < movieService.getAll().size(); i++) {
        	Movie movie = movieService.findByIndex(i);
        	String viewed = movie.getIsViewed();
        	
        	System.out.println("============");
        	System.out.println((i+1)+". "+movie.getTitle());
        	System.out.println(movie.getGenre());
        	System.out.println("visto: "+viewed);
        }
        System.out.println("0. Regresar al menu anterior");
    	System.out.println("============");
        System.out.println("Tu opcion: ");
	}

	/**
	 * Loop del menu de las peliculas, despliegue del mennu
	 */
	@Override
	public void interact() {
		if(movieService == null) {
			System.out.println("No ha sido inicializado el servicio para peliculas en el"
					+ "componente de vista");
		} else {
			while(true) {
				// actualizando el tamano de la lista cada vez que se repite el ciclo
				this.maxOption = movieService.getAll().size();
				this.showMenu();
				
				int option = this.getInputAndValidating();
				
				if(option == 0) {
					System.out.println("Has salido al menu principal...");
					break;
				}else {
					this.showResourcePlayer(option - 1);
				}
			}
		}
		
	}

	@Override
	public void showResourcePlayer(int option) {
		System.out.println("[REPRODUCIENDO LA PELICULA ]: "
					+ movieService.findByIndex(option).getTitle());
		
		System.out.println("");
	}

}
