package com.eduardocode.jasonviewer.repository;

import java.util.ArrayList;

/**
 * Patron principal para todos los repositorios
 * @author cheetos
 *
 * @param <T>
 */
public interface JVRepository<T> {

	public ArrayList<T> getAll();
	
	public T findByIndex(int index);
	
	public int getResourceIndex(T resource);
	
	public void insert(T resource);
	
	public boolean delete(T resource);
	
	public boolean update(int index, T resource);
}
