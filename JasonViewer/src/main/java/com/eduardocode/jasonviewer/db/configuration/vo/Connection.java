/**
 * 
 */
package com.eduardocode.jasonviewer.db.configuration.vo;

import lombok.Data;

/**
 * <h1>Connection</h1>
 * Clase de objeto virtual para el mapeo de propiedades yaml
 * @author Eduardo Rasgado Ruiz
 *
 */
@Data
public final class Connection {
	private Credentials credentials;
	private Driver driver;
	private String host;
	private int port;
	private String db;
	private String localTimezone;

	@Override
	public String toString() {
		return "Connection [credentials=" + credentials + "]";
	}
}
