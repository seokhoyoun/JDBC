package book.mvc.view;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import book.mvc.controller.BookController;
import book.mvc.model.vo.Book;

public class BookMenu {
	/*
	public Book inputBook()	=> 새 도서정보 키보드 입력용
	public Book inputBook(Book b)  => 수정도서정보 키보드 입력용
	public int inputBookId()	=> 검색/삭제할 도서 아이디 입력용
	public String inputBookTitle() => 도서제목 키보드 입력용
	public void displayBooks(List<Book> list) => 도서목록 출력용
	public void displayBook(Book b)	=> 도서 출력용
	public void displayError(String message) => 에러메세지 출력용
	 */
	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();
	
	public void displayMenu(){
		while(true) {
		System.out.print("	*** 도서 관리 프로그램 ***\r\n" + 
				"\r\n" + 
				"	1. 도서 추가\r\n" + 
				"	2. 가격 정보 수정\r\n" + 
				"	3. 도서 삭제\r\n" + 
				"	4. 도서 아이디로 조회\r\n" + 
				"	5. 도서 제목으로 조회\r\n" + 
				"	6. 도서 목록 전체 조회\r\n" + 
				"	9. 끝내기\r\n" + 
				"	번호 선택 : ");
		int mnum = sc.nextInt();
		sc.nextLine();
		switch(mnum) {
		case 1 : bc.insertBook(inputBook()); break;
		case 2 : bc.updateBook(inputBook(new Book())); break;
		case 3 : bc.deleteBook(inputBookId()); break;
		case 4 : displayBook(bc.searchBook(inputBookId())); break;
		case 5 : displayBooks(bc.searchBookTitle(inputBookTitle())); break;
		case 6 : displayBooks(bc.selectAll()); break;
		case 9 : return;
		}
		
		}
	}

	public String inputBookTitle() {
		System.out.print("\n책 제목 입력 : ");
		return sc.nextLine();
	}

	public int inputBookId() {
		System.out.print("\n책 번호 입력 : ");
		return sc.nextInt();
	}

	public Book inputBook(Book book) {
		System.out.print("\n변경 할 책 아이디 번호 입력 : ");
		book.setBid(sc.nextInt());
		System.out.print("변경 할 가격 입력 : ");
		book.setPrice(sc.nextInt());
		return book;
	}

	public Book inputBook() {
		Book book = new Book();
		System.out.print("책 제목 입력 : ");
		book.setTitle(sc.nextLine());
		System.out.print("저자명 입력 : ");
		book.setAuthor(sc.nextLine());
		System.out.print("출판사 입력 : ");
		book.setPublisher(sc.nextLine());
		System.out.print("출판 날짜 입력 [yyyy-mm-dd]: ");
		book.setDate(Date.valueOf(sc.next()));
		System.out.print("가격 입력 : ");
		book.setPrice(sc.nextInt());
		return book;
	}
	
	public void displayBooks(List<Book> list) {
		for(Book e : list) {
			System.out.println(e);
		}
	}
	
	public void displayBook(Book b) {
		System.out.println(b);
	}
	
	public void displayError(String mes) {
		System.out.println(mes);
	}
	
}
