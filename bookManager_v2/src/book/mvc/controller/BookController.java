package book.mvc.controller;

import java.util.ArrayList;

import book.mvc.model.service.BookService;
import book.mvc.model.vo.Book;
import book.mvc.view.BookMenu;

public class BookController {
	
	BookService bs = new BookService();
	
	public void insertBook(Book book) {
		int result = bs.insertBook(book);
		if(result > 0)
			System.out.println("\n도서 추가 완료");
		else
			System.out.println("\n도서 정보 저장에 실패했습니다. \n확인 후 다시 시도해주세요.");
	}

	public void updateBook(Book book) {
		int result = bs.updateBook(book);
		if(result > 0) 
			System.out.println("\n가격 수정 완료");
		else 
			System.out.println("\n가격 정보 변경에 실패했습니다.");
		
	}

	public void deleteBook(int bid) {
		int result = bs.deleteBook(bid);
		if(result <= 0)
			new BookMenu().displayError("도서 정보 삭제를 실패했습니다.");
		else
			System.out.println("도서 정보 삭제 성공");
	}

	public Book searchBook(int bid) {
		Book emp = bs.searchBook(bid);
		if(emp == null) 
			new BookMenu().displayError("조회 된 도서 정보가 없습니다.");
		return emp;
			
		
	}

	public ArrayList<Book> searchBookTitle(String title) {
		ArrayList<Book> list = bs.searchBookTitle(title);
		if(list.isEmpty()) 
			new BookMenu().displayError("조회된 도서 정보가 없습니다.");
		return list;
		
	}

	public ArrayList<Book> selectAll() {
		ArrayList<Book> list = bs.selectAll();
		if(list.isEmpty())
			new BookMenu().displayError("조회된 도서 정보가 없습니다.");
		return list;
	}

}
