/**
 * 
 */
package com.eduardocode.app;

/**
 * <h1>ClasesAnidadasJava</h1>
 * Proyecto en el que se exploran las posibilidades con clases anidadas en
 * java
 * 
 * @author Eduardo Rasgado Ruiz
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OutterClass outter = new OutterClass(100);

	    outter.callingInnerClassMethod();
	    outter.callingInnerAbstractClassMethod();
	}

}
