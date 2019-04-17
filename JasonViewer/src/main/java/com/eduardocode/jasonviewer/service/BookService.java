package com.eduardocode.jasonviewer.service;

import java.util.ArrayList;

import com.eduardocode.jasonviewer.model.Book;
import com.eduardocode.jasonviewer.repository.BookRepository;

/**
 * Servicio para interactuar entre la interfaz de la aplicacion y el repositorio
 * del modelo de Libro.
 * @author cheetos
 *
 */
public class BookService implements IWatchableService<Book> {

	private BookRepository bookRepository;
	
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

}
