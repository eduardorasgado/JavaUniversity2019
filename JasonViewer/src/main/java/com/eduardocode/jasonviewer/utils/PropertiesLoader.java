package com.eduardocode.jasonviewer.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.yaml.snakeyaml.Yaml;

import com.eduardocode.jasonviewer.db.configuration.vo.Configuration;

import lombok.Data;

/**
 * <h1>PropertiesLoader</h1>
 * Clase que abstrae la lectura de un archivo de propiedades yaml y puede traer
 * estas propiedades y mapearlas en objetos virtuales de configuracion
 * @author Eduardo Rasgado Ruiz
 * @see Configuration
 *
 */
@Data
public class PropertiesLoader {
	private final String locationFile = "src\\main\\resources\\application.yaml";
	private Yaml yaml;
	
	// objeto de mapeo principal del yaml
	Configuration configuration = null;
	
	public PropertiesLoader() {
		this.yaml = new Yaml();
		this.initYamlConfiguration();
	}
	
	/**
	 * Metodo que crea un stream de entrada para leer una direccion de archivo
	 * en el sistema operativo, con esta misma y tomando de base un objeto Yaml
	 * de la libreria snakeyaml hace un mapeo de propiedades hacia un
	 * Objeto de tipo Configuracion.
	 */
	private void initYamlConfiguration() {
		try{
			InputStream in = Files.newInputStream(Paths.get(locationFile));
			configuration = yaml.loadAs(in, Configuration.class);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
