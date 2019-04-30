/**
 * 
 */
package com.eduardocode.jasonviewer.view.component.reporter;

import java.util.Date;

/**
 * @author Eduardo Rasgado Ruiz
 *
 */
public class DateReporterUIComponent extends GenericReporterComponent {

	private Date date;
	
	@Override
	protected void showMainMenu() {
		System.out.println("::TODAY REPORTER"+date+"::");
		System.out.println("1. Reporte de peliculas");
		System.out.println("2. Reporte de series");
		System.out.println("3. Reporte de libros");
		System.out.println("0. Salir");
		
	}

	@Override
	public void interact() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void showMovieReport() {
		// TODO Auto-generated method stub
		
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
		this.date = date; 
	}

}
