package com.eduardocode.reportbuilder.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * <h1>Report</h1>
 * Libreria que permite crear un objeto de reporteo para una aplicacion
 * 
 * <p>
 * permite crear archivos externos a partir de contenido dinamico previamente
 * proporcionado por el programa que lo integra
 * 
 * @author Eduardo Rasgado Ruiz
 * @version 1.0
 * @since 2019
 *
 */
public class Report {
	private String nameFile;
	private String content;
	private String title;
	private String extension;
	
	/**
	 * Metodo principal de la libreria con la cual se genera el reporte deseado
	 * por el usuario, este hace uso del nombre del archivo, contenido, titulo
	 * y la extension del archivo
	 */
	public void buildReport() {
		if(getNameFile() != null && getTitle() != null && getContent() != null) {
			// crear el archivo
			File file = new File(getNameFile()+"."+getExtension());
			FileOutputStream outputStream = null;
			try {
				outputStream = new FileOutputStream(file);
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			// conversion a caracteres
			OutputStreamWriter streamWriter = new OutputStreamWriter(outputStream);
			// leer elementos mucho mas rapido
			BufferedWriter bufferWriter = new BufferedWriter(streamWriter);
			try {
				bufferWriter.write(getTitle());
				bufferWriter.newLine();
				for(String ct : getContent().split("\n")) {
					bufferWriter.write(ct);
					bufferWriter.newLine();
				}
				bufferWriter.close();
			} catch(IOException e) {
				e.printStackTrace();
			}	
			
		} else {
			System.out.println("No se aceptan datos vacios en el archivo");
		}
	}
	
	public String getNameFile() {
		return nameFile;
	}
	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	
	
}
