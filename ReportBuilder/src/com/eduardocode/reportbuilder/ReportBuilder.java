package com.eduardocode.reportbuilder;

import com.eduardocode.reportbuilder.model.Report;

public class ReportBuilder {

	public static void main(String[] args) {
		String nameFile = "miReporte";
		String extension = "txt";
		String titulo = "::REPORTE::\n";
		String contenido = "\nlorem ipsum dolor sit amet";
		for(int i = 0; i < 100; i++) {
			contenido += "\nReporte: "+i;
		}
		
		Report report = new Report();
		
		report.setTitle(titulo);
		report.setExtension(extension);
		report.setNameFile(nameFile);
		report.setContent(contenido);
		
		System.out.println("Contruyendo el reporte.");
		report.buildReport();
		System.out.println("Reporte terminado.");
	}

}
