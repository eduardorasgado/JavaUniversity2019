/**
 * 
 */
package com.eduardocode.jasonviewer.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.eduardocode.jasonviewer.model.Book;
import com.eduardocode.jasonviewer.model.Book.Page;
import com.eduardocode.jasonviewer.repository.BookRepository;

/**
 * Servicio para interactuar entre la interfaz de la aplicacion y el repositorio
 * del modelo de Libro.
 * @author cheetos
 *
 */
public class BookService extends WatchableService implements IWatchableService<Book> {

	private BookRepository bookRepository;
	private Scanner scanner;
	
	public BookService() {
		bookRepository = new BookRepository();
	}
	
	/**
	 * Devuelve una lista de libros
	 */
	@Override
	public ArrayList<Book> getAll() {
		return bookRepository.getAll();
	}

	/**
	 * Devuelve el indice de un libro en la db
	 */
	@Override
	public int getResourceIndex(Book book) {
		return bookRepository.getResourceIndex(book);
	}

	/**
	 * metodo que recupera un libro dado su indice
	 */
	@Override
	public Book findByIndex(int index) {
		return bookRepository.findByIndex(index);
	}

	/**
	 * Metodo que actualiza un libro dado su indice y la nueva instancia del libro
	 */
	@Override
	public boolean update(int index, Book book) {
		return bookRepository.update(index, book);
	}

	/**
	 * Metodo que elimina un libro en el repositorio de estos
	 */
	@Override
	public boolean delete(int index) {
		return bookRepository.delete(index);
	}

	/**
	 * Metodo que actualiza un libro cuando este es leido
	 */
	@Override
	public void playResource(int index) {
		// libro que va a ser actualizado
		Book book = bookRepository.getAll().get(index);
		
		Date dateInicio = book.startToSee(new Date());
		
		//this.simulateTimeLapse(1000);
		
		book = this.playPages(book);
		
		// el tiempo que fue leido el libro
		book.stoptToSee(dateInicio, new Date());
		
		// guardando el recurso
		this.bookRepository.update(index, book);
	}
	
	private Book playPages(Book book) {
		ArrayList<Book.Page> totalPages = book.getPages();
		// lectura de las paginas dentro de un libro
		scanner = new Scanner(System.in);
		int i = 0;
		do {
			Page actualPage = totalPages.get(i);
			
			System.out.println("Page: "+actualPage.getNumber());
			System.out.println(actualPage.getContent());
			System.out.println("....");
			
			if(actualPage.getNumber() == totalPages.size()) {
				// si la pagina en la que estamos es igual al numero ttal de 
				//paginas entonces ya leimos todo el libro
				book.setRead(true);
			} else {
				System.out.println("1. Ir a la sig pagina");
			}
			
			if(actualPage.getNumber() > 1) {
				System.out.println("2. Ir a la pagina anterior");
			}
			System.out.println("0. cerrar libro");
		
			// validacion e interpretacion de la respuesta
			int response = Integer.valueOf(scanner.nextLine());
			
			if(response == 1)  {
				i++;
			}
			else if(response == 2 && actualPage.getNumber() > 1) {
				i--;
			}
			else if(response == 0) {
				System.out.println("Cerrando libro");
				break;
			}
			else {
				System.out.println("Respuesta invalida");
			}
		} while(i < book.getPages().size());
		
		return book;
	}

}

