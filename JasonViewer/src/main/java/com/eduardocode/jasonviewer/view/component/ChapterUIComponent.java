/**
 * 
 */
package com.eduardocode.jasonviewer.view.component;

import java.util.ArrayList;

import com.eduardocode.jasonviewer.model.Chapter;
import com.eduardocode.jasonviewer.model.Serie;
import com.eduardocode.jasonviewer.service.ChapterService;
import com.eduardocode.jasonviewer.service.SerieService;
import com.eduardocode.jasonviewer.view.GenericViewComponent;

import lombok.Data;

/**
 * Componente del servicio de los capitulos de una serie especifica
 * @author cheetos
 *
 */
@Data
public class ChapterUIComponent extends GenericViewComponent implements IFrontComponent<Chapter, ChapterService> {

	private SerieService serieService = null;
	private ChapterService chapterService = null;
	private int serieIndex;
	
	@Override
	public void setService(ChapterService chapterService) {
		this.chapterService = chapterService;
	}

	/**
	 * Reproduce el el menu correspondiente a los capitulos de una serie
	 * determinada.
	 * 
	 * En el metodo de interact es donde se actualiza el maxoption dado el ser
	 * vicio de chapter en su funcion de play resource, el cual hace solicitud de
	 * un servicio de serie, junto al indice de la serie que se esta ejecutando
	 */
	@Override
	public void interact() {
		if(chapterService == null) {
			System.out.println("No ha sido inicializado el servicio para chapters en el"
					+ "componente de vista");
		} else {
			while(true) {
				// loop principal
				this.showMenu();
				break;
			}
		}
	}

	/**
	 * Se listan e imprimen los capitulos de una serie determinada
	 */
	@Override
	public void showMenu() {
		// dado el indice de la serie
		Serie serie = serieService.findByIndex(serieIndex);
		ArrayList<Chapter> capitulos = serie.getChapters();
		
		System.out.println(":: TODOS LOS CAPITULOS::");
		for(int i = 0; i < capitulos.size(); i++) {
			Chapter capitulo = capitulos.get(i);
			System.out.println((i+1)+". "+capitulo.getTitle());
		}
		
	}

	@Override
	public void showResourcePlayer(int option) {
		// TODO Auto-generated method stub
		
	}

}
