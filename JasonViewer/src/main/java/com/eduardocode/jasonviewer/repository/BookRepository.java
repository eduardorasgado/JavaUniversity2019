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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findByIndex(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getResourceIndex(Book resource) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insert(Book resource) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete(int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(int index, Book resource) {
		// TODO Auto-generated method stub
		return false;
	}

}
