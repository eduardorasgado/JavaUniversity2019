/**
 * 
 */
package com.eduardocode.jasonviewer.service;

import java.util.ArrayList;

import com.eduardocode.jasonviewer.model.Serie;
import com.eduardocode.jasonviewer.repository.SerieRepository;

/**
 * @author cheetos
 *
 */
public class SerieService implements IWatchableService<Serie> {

	private SerieRepository serieRepository;
	
	public SerieService() {
		this.serieRepository = new SerieRepository();
	}

	@Override
	public ArrayList<Serie> getAll() {
		return serieRepository.getAll();
	}

	@Override
	public int getResourceIndex(Serie resource) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Serie findByIndex(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int index) {
		// TODO Auto-generated method stub
		return false;
	}

}
