package com.eduardocode.jasonviewer;

import com.eduardocode.jasonviewer.service.BookService;
import com.eduardocode.jasonviewer.service.ChapterService;
import com.eduardocode.jasonviewer.service.MovieService;
import com.eduardocode.jasonviewer.service.SerieService;
import com.eduardocode.jasonviewer.view.UserInterface;

public class Main {
	public static void main(String[] args) {
		System.out.println("[BIENVENID@ A JASONVIEWER]");
		
		MovieService movieService = new MovieService();
		SerieService serieService = new SerieService();
		ChapterService chapterService = new ChapterService();
		BookService bookService = new BookService();
		
		UserInterface ui = new UserInterface(
				movieService,
				serieService,
				chapterService,
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
