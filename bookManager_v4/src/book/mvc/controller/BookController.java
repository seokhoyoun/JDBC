package book.mvc.controller;

import java.util.ArrayList;

import book.mvc.exception.BookException;
import book.mvc.model.service.BookService;
import book.mvc.model.vo.Book;
import book.mvc.view.BookMenu;
import common.JDBCTemp;

public class BookController {
	
	private BookService bs;
	
	public BookController() {
		try {
			bs = new BookService();
		} catch (BookException e) {
			new BookMenu().displayError(e.getMessage());
		}
	}
	

	
	public void insertBook(Book book) {
		try {
			int result = bs.insertBook(book);
			if(result > 0)
				System.out.println("\n도서 추가 완료");
		} catch (BookException e) {
			new BookMenu().displayError(e.getMessage());
		}
	}

	public void updateBook(Book book) {
		try {
			int result = bs.updateBook(book);
			if(result > 0) 
				System.out.println("\n가격 수정 완료");
		} catch (BookException e) {
			new BookMenu().displayError(e.getMessage());
		}
		
	}

	public void deleteBook(int bid) {
		try {
			int result = bs.deleteBook(bid);
			if(result > 0)
				System.out.println("\n도서 정보 삭제 완료");
		} catch (BookException e) {
			new BookMenu().displayError("도서 정보 삭제를 실패했습니다.");
		}
	}

	public Book searchBook(int bid) {
		Book emp = null;
		try {
			emp = bs.searchBook(bid);
			if(emp == null) 
				new BookMenu().displayError("조회 된 도서 정보가 없습니다.");
		} catch (BookException e) {
			new BookMenu().displayError(e.getMessage());
		}
		return emp;
			
		
	}

	public ArrayList<Book> searchBookTitle(String title) {
		ArrayList<Book> list = null;
		try {
			list = bs.searchBookTitle(title);
			if(list.isEmpty()) 
				new BookMenu().displayError("조회된 도서 정보가 없습니다.");
		} catch (BookException e) {
			new BookMenu().displayError(e.getMessage());
		}
		return list;
		
	}

	public ArrayList<Book> selectAll() {
		ArrayList<Book> list = null;
		try {
			list = bs.selectAll();
			if(list.isEmpty())
				new BookMenu().displayError("조회된 도서 정보가 없습니다.");
		} catch (BookException e) {
			new BookMenu().displayError(e.getMessage());
		}
		return list;
	}

}
