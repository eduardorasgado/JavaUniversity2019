/**
 * 
 */
package com.eduardocode.jasonviewer.db.configuration.vo;

import lombok.Data;

/**
 * <h1>Driver</h1>
 * Clase de objeto virtual que representa las caracteristicas del driver
 * en las propiedades del yaml
 * @author Eduardo Rasgado Ruiz
 *
 */
@Data
public final class Driver {
	private String packageDir;
	private String dbengine;
}
