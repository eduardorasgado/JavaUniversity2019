/**
 * 
 */
package com.eduardocode.app;

/**
 * <h1>OutterClass</h1> Clase que no hereda de ninguna otra pero que implementa
 * otras clases en su estructura interna
 * 
 * @author Eduardo Rasgado Ruiz
 *
 */
public class OutterClass {
	private int bufferSize;
	private int bufferHeap[];
	private SomeAbstractClass someAc;

	public OutterClass(int bufferSize) {
		this.bufferSize = bufferSize;
		bufferHeap = new int[this.bufferSize];
		bufferHeap[0] = 10;
		initAbstractClass();
	}

	// clase estatica interna
	public static class InnerClass {
		private int size;
		private boolean status;

		// metodo estatico de la clase interna
		public static void run() {
			System.out.println("run inside static inner class");
		}
	}

	public String someOutterMethod(String word) {
		String concatenation = word + " a word";
		return concatenation;
	}

	public void callingInnerClassMethod() {
		InnerClass.run();
	}

	public void callingInnerAbstractClassMethod() {
		someAc.run();
	}

	public void initAbstractClass() {

		this.someAc = new SomeAbstractClass() {
			public void run() {
				System.out.println("run abstract class");
			}

			public String giveSomeString() {
				return "this is an inner abstract class";
			}
		}; // es necesario cerrar con punto y coma despues de definir una
			// clase abstracta interna en otra clase
	}

}
