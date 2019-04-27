package com.eduardocode.jasonviewer.repository;

import java.util.ArrayList;
import java.util.Date;

import com.eduardocode.jasonviewer.model.Book;

/**
 * Repositorio que controla todas las operaciones o transacciones entre la base 
 * de datos o lista que contiene todos los libros con los que se cuenta en la
 * aplicacion y el servicio de los libros en la logica de negocio
 * @author cheetos
 *
 */
public class BookRepository implements JVRepository<Book> {

	private ArrayList<Book> books = null;
	
	public BookRepository() {
		books = new ArrayList<Book>();
		this.initBookList();
	}
	
	/**
	 * Devuelve todos los libros del repositorio
	 */
	@Override
	public ArrayList<Book> getAll() {
		return books;
	}

	/**
	 * devuelve una entidad de libro existente en el repositorio dado un indice
	 */
	@Override
	public Book findByIndex(int index) {
		if(index >=0 && index < books.size()) {
			return books.get(index);
		} else {
			return null;
		}
	}

	/**
	 * devuelve el indice de un libro determinado dentro del repositorio, 
	 * dada la instancia del libro
	 */
	@Override
	public int getResourceIndex(Book book) {
		for(int i = 0;i < books.size(); i++) {
			if(books.get(i).getTitle().equals(book.getTitle())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Crea un nuevo libro dentro del repositorio a partir de una entidad 
	 * proporcionada
	 */
	@Override
	public void insert(Book book) {
		if(book != null) {
			books.add(book);
		}
		
	}

	/**
	 * Elimina un libro existente en el repositorio de libros, dado el indice de
	 * este
	 */
	@Override
	public boolean delete(int index) {
		if(index >=0 && index < books.size()) {
			books.remove(index);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Actualiza un libro dentro del repositorio, dado el indice de este libro
	 * y la instancia de este con los datos actualizados
	 */
	@Override
	public boolean update(int index, Book book) {
		if((index >= 0 && index < books.size()) && book != null) {
			books.set(index, book);
			return true;
		} else {
			return false;
		}
	}
	
	private void initBookList() {
		
		ArrayList<Book.Page> pages = new ArrayList<Book.Page>();
		for(int i = 0; i < 3; i++) {
			pages.add(new Book.Page(i+1, "Estas leyendo la pagina "+(i+1) ));
		}
		
		this.books.add(new Book("Hagame caso", "negocios", new Date(), pages));
		this.books.add(new Book("The lean Startup", "emprendimiento", new Date(), pages));
		this.books.add(new Book("Padre rico, padre pobre", "negocios", new Date(), pages));
		this.books.add(new Book("Ce qui va changer le marques", "marketing", new Date(), pages));
		this.books.add(new Book("lost and founder", "emprendimiento", new Date(), pages));
	}

}
