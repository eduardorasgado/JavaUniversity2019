/**
 * 
 */
package com.eduardocode.jasonviewer.service;

import com.eduardocode.jasonviewer.repository.ChapterRepository;

/**
 * Servicio que ofrece una interaccion entre la vista y las transacciones 
 * de los capitulos
 * @author cheetos
 *
 */
public class ChapterService  extends WatchableService {
	
	ChapterRepository chapterRepository;
	
	public ChapterService() {
		this.chapterRepository = new ChapterRepository();
	}

	@Override
	public void playResource(int index) {
		//
	}

}
