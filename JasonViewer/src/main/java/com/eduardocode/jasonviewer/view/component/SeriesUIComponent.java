/**
 * 
 */
package com.eduardocode.jasonviewer.view.component;

import com.eduardocode.jasonviewer.model.Serie;
import com.eduardocode.jasonviewer.service.ChapterService;
import com.eduardocode.jasonviewer.service.SerieService;
import com.eduardocode.jasonviewer.view.GenericViewComponent;

import lombok.Data;

/**
 * Componente que permite la interaccion entre el usuario y las series, asi mismo
 * con sus capitulos
 * @author cheetos
 *
 */
@Data
public class SeriesUIComponent extends GenericViewComponent implements IFrontComponent<Serie, SerieService> {

	protected SerieService serieService;
	protected ChapterService chapterService;
	
	private ChapterUIComponent chapterComponent;
	
	public 	SeriesUIComponent() {
		chapterComponent = new ChapterUIComponent();
		this.initChapterService();
	}
	
	@Override
	public void setService(SerieService serieService) {
		this.serieService = serieService;
		this.maxOption = serieService.getAll().size();
	}

	/**
	 * seleccion de  la serie deseada por el usuario, o en caso contrario volver
	 * al menu principal
	 */
	@Override
	public void interact() {
		if(serieService == null) {
			System.out.println("No ha sido inicializado el servicio para series en el"
					+ "componente de vista");
		} else {
			while(true) {
				// actualizando el tamano de la lista cada vez que se repite el ciclo
				this.maxOption = serieService.getAll().size();
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

	/**
	 * Muestra las series disponibles en la aplicacion
	 */
	@Override
	public void showMenu() {
		System.out.println("::SERIES::");
		for(int i = 0; i < this.maxOption; i++) {
			Serie serie = serieService.findByIndex(i);
			String viewed = serie.getIsViewed();
			
			System.out.println("============");
        	System.out.print((i+1)+". "+serie.getTitle());
        	System.out.print(" | genero: "+serie.getGenre());
        	System.out.println(" | visto: "+viewed);
		}
		System.out.println("============");
        System.out.println("0. Regresar al menu anterior");
    	System.out.println("============");
	}

	/**
	 * Llama al menu de visualizacion de capitulos definidos en una serie determi
	 * nada.
	 * Asi mismo actualiza el servicio de series con las series terminadas
	 * o los capitulos vistos de una serie
	 */
	@Override
	public void showResourcePlayer(int option) {
		System.out.println("[JASON VIEWER: SERIES]: "+ serieService.findByIndex(option).getTitle());
		
		// se actualiza el servicio de serie para el componente de capitulo
		this.chapterComponent.setSerieService(serieService);
		// se actualiza el indice de la serie a visualizar
		this.chapterComponent.setSerieIndex(option);
		
		// se manda a traer el loop de interact
		this.chapterComponent.interact();
		
		// se actualiza el servicio de series ya que asi sabemos si se marcaron las series 
		// y los capitulos vistos
		this.serieService = this.chapterComponent.getSerieService();
		// al final, se actualiza el servicio de chapter
		// aunque no es necesario
		this.chapterService = this.chapterComponent.getChapterService();
	}
	
	/**
	 * Inicializa  el servicio de capitulos e incluye este servicio
	 * dentro del componente ui de capitulos que esta dentro del componente de series 
	 */
	private void initChapterService() {
		this.chapterService = new ChapterService();
		chapterComponent.setService(chapterService);
	}

}
