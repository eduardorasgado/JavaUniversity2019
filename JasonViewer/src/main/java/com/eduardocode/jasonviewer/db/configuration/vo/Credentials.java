/**
 * 
 */
package com.eduardocode.jasonviewer.db.configuration.vo;

import lombok.Data;

/**
 * <h1>Credentials</h1>
 * abtraccion de propiedades de un archivo yaml, un nivel abajo de connection
 * @author Eduardo Rasgado Ruiz
 *
 */
@Data
public final class Credentials {
	private String user;
	private String password;
}
