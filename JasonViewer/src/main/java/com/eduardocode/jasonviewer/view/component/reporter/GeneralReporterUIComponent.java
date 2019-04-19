/**
 * 
 */
package com.eduardocode.jasonviewer.view.component.reporter;

/**
 * Componente visual que representa la interaccion entre el usuario y la creacion
 * de reportes generales
 * @author cheetos
 *
 */
public class GeneralReporterUIComponent extends GenericReporterComponent {
	
	public GeneralReporterUIComponent(int servicesQuantity) {
		this.maxOption = servicesQuantity;
	}
	
	/**
	 * Impresion en pantalla del menu general
	 */
	@Override
	protected void showMainMenu() {
		System.out.println("::GENERAL REPORTER::");
		System.out.println("1. Reporte de peliculas");
		System.out.println("2. Reporte de series");
		System.out.println("3. Reporte de libros");
		System.out.println("0. Salir");
	}

	/**
	 * loop o logica principal para la interaccion entre el reporter y el usuario
	 */
	@Override
	public void interact() {
		if((movieService !=null) && (serieService != null) && (bookService != null)) {
			while(true) {
				this.showMainMenu();
				int option = this.getInputAndValidating();
				if(option == 0) {
					System.out.println("Saliendo al menu principal...");
					break;
				} else {
					// impresion de reporter dada la opcion elegida por el usuario
					System.out.println("Reporter.... doing something");
					// implementado en genericreportercomponent
					this.runResourceReport(option);
				}
			}
		} else {
			System.out.println("Uno o mas servicios no han sido configurados para la"
					+ "correcta función del reporter");
		}
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

}
