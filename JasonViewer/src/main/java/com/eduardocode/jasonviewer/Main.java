package com.eduardocode.jasonviewer;

import java.util.ArrayList;

import com.eduardocode.jasonviewer.model.Book;
import com.eduardocode.jasonviewer.model.Chapter;
import com.eduardocode.jasonviewer.model.Movie;
import com.eduardocode.jasonviewer.model.Serie;
import com.eduardocode.jasonviewer.service.BookService;
import com.eduardocode.jasonviewer.service.ChapterService;
import com.eduardocode.jasonviewer.service.MovieService;
import com.eduardocode.jasonviewer.service.SerieService;

public class Main {

	public static void main(String[] args) {
		System.out.println("[BIENVENID@ A JASONVIEWER]");
		
		MovieService movieService = new MovieService();
		SerieService serieService = new SerieService();
		ChapterService chapterService = new ChapterService();
		BookService bookService = new BookService();
		
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
		System.out.println("\n");
		
		Serie s2 = serieService.getAll().get(0);
		
		System.out.println("Serie "+s2.getTitle()+" vista: "+s2.getIsViewed());
		Chapter c2 = s2.getChapters().get(2);
		System.out.println("chapter en service: "+ c2.getTitle()+", visto: "+ c2.getIsViewed());
		serieService = chapterService.playResource(serieService, 2, s2);
		System.out.println("Serie vista...");
		
		System.out.println("VIENDO UN CAPITULO");
		for(Chapter c : serieService.getAll().get(0).getChapters()) {
			System.out.println("chapter en service: "+ c.getTitle()+", visto: "+ c.getIsViewed());
		}
		
		System.out.println("VIENDO TODOS LOS CAPITULOS");
		for(int i = 0; i < s2.getChapters().size(); i++) {
			// viendo todos los capitulos de una serie
			serieService = chapterService.playResource(serieService, i, s2);
		}
		
		for(Chapter c : serieService.getAll().get(0).getChapters()) {
			System.out.println("chapter en service: "+ c.getTitle()+", visto: "+ c.getIsViewed());
		}
		
		System.out.println("Serie "+s2.getTitle()+" vista: "+s2.getIsViewed());
		
		// TESTEANDO LIBROS
		
		System.out.println("[TESTING BOOKS]");
		bookService.getAll().forEach( (Book book) -> {
			System.out.println("Libro: "+book.getTitle()+", visto: "+book.getIsRead());
		});
		
		System.out.println("Leyendo el libro 2...");
		// suponiendo que leemos el libro 2
		bookService.playResource(1);
		
		bookService.getAll().forEach( (Book book) -> {
			System.out.println("Libro: "+book.getTitle()+", leido: "+book.getIsRead());
		});
	}
}
