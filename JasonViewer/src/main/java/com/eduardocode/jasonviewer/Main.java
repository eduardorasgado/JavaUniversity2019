package com.eduardocode.jasonviewer;

import java.util.ArrayList;

import com.eduardocode.jasonviewer.model.Chapter;
import com.eduardocode.jasonviewer.model.Movie;
import com.eduardocode.jasonviewer.model.Serie;
import com.eduardocode.jasonviewer.service.MovieService;
import com.eduardocode.jasonviewer.service.SerieService;

public class Main {

	public static void main(String[] args) {
		System.out.println("[BIENVENID@ A JASONVIEWER]");
		
		MovieService movieService = new MovieService();
		SerieService serieService = new SerieService();
		
		// TESTEANDO MOVIES
		System.out.println("\n\n MOVIES");
		
		ArrayList<Movie> movies = movieService.getAll();
		movies.forEach((Movie m) -> {
			System.out.println("pelicula: "+m.getTitle()+", visto: "+m.getIsViewed());
		});
		
		System.out.println("Viendo una pelicula...\n");
		//movieService.playResource(2);
		
		// TODO: testing de eliminacion de una pelicula
		System.out.println("Buscando pelicula");
		Movie movieToDelete = movieService.findByIndex(4);
		
		int index = movieService.getResourceIndex(movieToDelete);
		
		if(movieService.delete(index)) {
			System.out.println("Pelicula eliminada");
		}
		
		movieService.getAll().forEach((Movie m) -> {
			System.out.println("pelicula: "+m.getTitle()+", visto: "+m.getIsViewed());
		});
		
		
		// TESTEANDO SERIES
		System.out.println("\n\n SERIES");
		Serie serie = serieService.findByIndex(2);
		System.out.println("Serie: "+serie.getTitle());
		for(Chapter chapter : serie.getChapters()) {
			System.out.println("capitulo:"+chapter.getTitle()+",season a ver: "+chapter.getSeasonNumber());
		}
		
		serieService.getAll().forEach( (Serie s) ->{
			System.out.println("serie: "+s.getTitle() + ", SEASON QUANTITY: "+ s.getSeasonQuantity());
			for(Chapter c : s.getChapters()) {
				System.out.println("chapter name: "+c.getTitle()+", serie: "+c.getSerie().getTitle());
			}
		});
		
		
	}
}
