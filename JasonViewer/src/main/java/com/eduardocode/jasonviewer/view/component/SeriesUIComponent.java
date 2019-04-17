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
	
	@Override
	public void setService(SerieService serieService) {
		this.serieService = serieService;
		this.chapterService = new ChapterService();
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

	@Override
	public void showMenu() {
		System.out.println("::SERIES::");
		for(int i = 0; i < serieService.getAll().size(); i++) {
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
        System.out.println("Tu opcion: ");
		
	}

	@Override
	public void showResourcePlayer(int option) {
		System.out.println("[JASON VIEWER: SERIES]: "+ serieService.findByIndex(option).getTitle());
		
		//TODO: aqui se va a tener que mandar a llamar al componente visual de capitulos
	}

}
