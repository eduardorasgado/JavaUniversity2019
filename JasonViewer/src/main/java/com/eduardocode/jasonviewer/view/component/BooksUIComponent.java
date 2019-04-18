/**
 * 
 */
package com.eduardocode.jasonviewer.view.component;

import com.eduardocode.jasonviewer.model.Book;
import com.eduardocode.jasonviewer.service.BookService;
import com.eduardocode.jasonviewer.view.GenericViewComponent;

import lombok.Data;

/**
 * @author cheetos
 *
 */
@Data
public class BooksUIComponent extends GenericViewComponent implements IFrontComponent<Book, BookService> {
	
	private BookService bookService;

	@Override
	public void setService(BookService bookService) {
		this.bookService = bookService;
		this.maxOption = this.bookService.getAll().size();
	}

	@Override
	public void interact() {
		System.out.println("Leyendo libros...");
	}

	@Override
	public void showMenu() {
		System.out.println("::BOOKS::");
		for(int i = 0; i < this.maxOption; i++) {
			System.out.println((i+1)+". Libro");
		}
	}

	@Override
	public void showResourcePlayer(int option) {
		// TODO Auto-generated method stub
		
	}

}
