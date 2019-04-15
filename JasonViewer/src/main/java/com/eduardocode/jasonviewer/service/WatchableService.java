/**
 * 
 */
package com.eduardocode.jasonviewer.service;

/**
 * Implemeta metodos genericos para todo aquello que sea un servicio
 * @author cheetos
 *
 */
public abstract class WatchableService {
	
	/**
	 * Simula el tiempo en el que se ve o lee un recurso
	 * @param time
	 */
	public void simulateTimeLapse(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
