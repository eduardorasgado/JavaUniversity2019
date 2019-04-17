package com.eduardocode.jasonviewer.repository;

import java.util.ArrayList;

import com.eduardocode.jasonviewer.model.Book;

public class BookRepository implements JVRepository<Book> {

	private ArrayList<Book> books = null;
	
	public BookRepository() {
		books = new ArrayList<Book>();
	}
	
	@Override
	public ArrayList<Book> getAll() {
		return books;
	}

	@Override
	public Book findByIndex(int index) {
		if(index >=0 && index < books.size()) {
			return books.get(index);
		} else {
			return null;
		}
	}

	@Override
	public int getResourceIndex(Book book) {
		for(int i = 0;i < books.size(); i++) {
			if(books.get(i).getTitle().equals(book.getTitle())) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void insert(Book book) {
		if(book != null) {
			books.add(book);
		}
		
	}

	@Override
	public boolean delete(int index) {
		if(index >=0 && index < books.size()) {
			books.remove(index);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean update(int index, Book book) {
		if((index >= 0 && index < books.size()) && book != null) {
			books.set(index, book);
			return true;
		} else {
			return false;
		}
	}

}
