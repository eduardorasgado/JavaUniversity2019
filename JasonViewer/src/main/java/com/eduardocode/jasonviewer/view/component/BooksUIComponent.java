/**
 * 
 */
package com.eduardocode.jasonviewer.view.component;

import java.util.ArrayList;

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
	
	private ArrayList<Book> books = null;
	private BookService bookService;

	@Override
	public void setService(BookService bookService) {
		this.bookService = bookService;
		this.maxOption = this.bookService.getAll().size();
	}

	@Override
	public void interact() {
		if(bookService == null) {
			System.out.println("No ha sido inicializado el servicio para series en el"
					+ "componente de vista");
		} else {
			while(true) {
				this.books = this.bookService.getAll();
				this.maxOption = this.books.size();
				this.showMenu();
				
				int option = this.getInputAndValidating();
				
				if(option == 0) {
					System.out.println("Has salido al menu principal...");
					break;
				} else {
					this.showResourcePlayer(option - 1);
				}
			}
		}
	}

	@Override
	public void showMenu() {
		System.out.println("::BOOKS::");
		for(int i = 0; i < this.maxOption; i++) {
			Book book = bookService.findByIndex(i);
			System.out.println((i+1)+". "+book.getTitle()
					+" | leido: "+book.getIsRead());
		}
	}

	@Override
	public void showResourcePlayer(int option) {
		// TODO Auto-generated method stub
		System.out.println("Leyendo el libro: "
					+bookService.findByIndex(option).getTitle());
		bookService.playResource(option);
	}

}
