package com.eduardocode.jasonviewer;

import java.util.ArrayList;

import com.eduardocode.jasonviewer.model.Movie;
import com.eduardocode.jasonviewer.service.MovieService;

public class Main {

	public static void main(String[] args) {
		System.out.println("[BIENVENID@ A JASONVIEWER]");
		
		MovieService movieService = new MovieService();
		
		ArrayList<Movie> movies = movieService.getAll();
		movies.forEach((Movie m) -> {
			System.out.println("pelicula: "+m.getTitle()+", visto: "+m.getIsViewed());
		});
		
		System.out.println("Viendo una pelicula...\n");
		movieService.playResource(2);
		
		// TODO: testing de eliminacion de una pelicula
		System.out.println("Buscando pelicula");
		Movie movieToDelete = movieService.findByIndex(1);
		
		movieService.getResourceIndex(movieToDelete);
		
		movieService.delete(3);
		
		System.out.println("Pelicula eliminada");
		
		ArrayList<Movie> movies2 = movieService.getAll();
		
		movieService.getAll().forEach((Movie m) -> {
			System.out.println("pelicula: "+m.getTitle()+", visto: "+m.getIsViewed());
		});
	}
}
