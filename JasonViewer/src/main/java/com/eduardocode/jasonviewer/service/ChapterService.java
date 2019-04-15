/**
 * 
 */
package com.eduardocode.jasonviewer.service;

import java.util.ArrayList;

import com.eduardocode.jasonviewer.model.Chapter;
import com.eduardocode.jasonviewer.model.Serie;
import com.eduardocode.jasonviewer.repository.ChapterRepository;

/**
 * Servicio que ofrece una interaccion entre la vista y las transacciones 
 * de los capitulos
 * @author cheetos
 *
 */
public class ChapterService extends WatchableService{
	
	ChapterRepository chapterRepository;
	
	public ChapterService() {
		this.chapterRepository = new ChapterRepository();
	}

	
	public SerieService playResource(SerieService serieService, 
										int chapterIndex, Serie serie) {
		
		ArrayList<Chapter> chapters = serie.getChapters();
		Chapter chapterView = chapters.get(chapterIndex);
		int serieIndex = serieService.getResourceIndex(serie);
		// marcar el capitulo como visto
		chapterView.setViewed(true);
		
		// simulando el tiempo de vista
		this.simulateTimeLapse(200);
		
		// reemplazar el capitulo actualizado en la lista de capitulos
		chapters.set(chapterIndex, chapterView);
		// reemplazar la lista de capitulos actualizada en la serie
		serie.setChapters(chapters);
		// reemplazar la serie en la lista de los servicios de serie
		
		
		
		// si se vieron todos los capitulos ya, entonces la serie es marcada como vista
		int viewAccumulate = 0;
		for(Chapter c : chapters) {
			if(c.getViewed()) {
				viewAccumulate++;
			}
		}
		if(viewAccumulate == chapters.size()) {
			serie.setViewed(true);
		}
		
		serieService.update(serieIndex, serie);
		//se retorna el servicio de la serie
		return serieService;
		
	}


	@Override
	public void playResource(int index) {
		// dummy service method, no hace nada
		
	}

}
