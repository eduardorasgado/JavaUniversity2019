/**
 * 
 */
package com.eduardocode.jasonviewer.view.component.reporter;

import java.util.Date;

import com.eduardocode.jasonviewer.service.BookService;
import com.eduardocode.jasonviewer.service.MovieService;
import com.eduardocode.jasonviewer.service.SerieService;
import com.eduardocode.jasonviewer.view.GenericViewComponent;

import lombok.Data;

/**
 * @author cheetos
 *
 */
@Data
public abstract class GenericReporterComponent extends GenericViewComponent {
	protected MovieService movieService;
	protected SerieService serieService;
	protected BookService bookService;
	protected Date reportDate;
	
	protected abstract void showMainMenu();
	
	protected abstract void interact();
	
	protected abstract void showMovieReport();
	
	protected abstract void showSerieReport();
	
	protected abstract void showBookReport();
}
