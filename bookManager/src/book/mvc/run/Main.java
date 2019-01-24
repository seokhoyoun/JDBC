package book.mvc.run;

import book.mvc.view.BookMenu;

public class Main {
	
	public static void main(String[] args) {
		new BookMenu().displayMenu();
		System.out.println("정상적으로 종료되었습니다.");
	}
	
}
