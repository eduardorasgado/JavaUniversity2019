package com.eduardocode.jasonviewer;

import com.eduardocode.jasonviewer.service.BookService;
import com.eduardocode.jasonviewer.service.MovieService;
import com.eduardocode.jasonviewer.service.SerieService;
import com.eduardocode.jasonviewer.view.UserInterface;

public class Main {
	public static void main(String[] args) {
		
		MovieService movieService = new MovieService();
		SerieService serieService = new SerieService();
		BookService bookService = new BookService();
		
		UserInterface ui = new UserInterface(
				movieService,
				serieService,
				bookService,
				6
				);
		while(true) {
			ui.applicationLoop();
			if(ui.isCloseApp()) {
				break;
			}
		}
	}
}
