/**
 * 
 */
package com.eduardocode.jasonviewer.model;

import java.util.Date;

/**
 * Interfaz que representa un patron util para los modelos que sean de lectura
 * @author cheetos
 *
 */
public interface IReadable {
	Date startToSee(Date dateI);
    void stoptToSee(Date dateI, Date dateF);
}
