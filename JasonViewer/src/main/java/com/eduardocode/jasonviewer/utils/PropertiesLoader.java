package com.eduardocode.jasonviewer.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.yaml.snakeyaml.Yaml;

import lombok.Data;

@Data
public class PropertiesLoader {
	private final String locationFile = "src\\main\\resources\\application.yaml";
	private Yaml yaml;
	
	private String envPassword;
	
	public PropertiesLoader() {
		this.yaml = new Yaml();
		this.initYamlConfiguration();
	}
	
	private void initYamlConfiguration() {
		try{
			InputStream in = Files.newInputStream(Paths.get(locationFile));
			this.envPassword = yaml.load(in);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
