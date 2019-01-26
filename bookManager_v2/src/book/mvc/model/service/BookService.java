package book.mvc.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import book.mvc.model.dao.BookDao;
import book.mvc.model.vo.Book;
import common.JDBCTemp;
public class BookService {
	
	BookDao dao = new BookDao();
	
	public BookService() {
	}
	
	public int insertBook(Book book) {
		Connection conn = JDBCTemp.getConnection();
		int result = dao.insertBook(conn, book);
		if(result > 0)
			JDBCTemp.commit(conn);
		else
			JDBCTemp.rollback(conn);
		JDBCTemp.close(conn);
		return result;
	}

	public int updateBook(Book book) {
		Connection conn = JDBCTemp.getConnection();
		int result = dao.updateBook(conn, book);
		if(result > 0)
			JDBCTemp.commit(conn);
		else
			JDBCTemp.rollback(conn);
		JDBCTemp.close(conn);
		return result;
		
	}

	public int deleteBook(int bid) {
		Connection conn = JDBCTemp.getConnection();
		int result = dao.deleteBook(conn, bid);
		if(result > 0)
			JDBCTemp.commit(conn);
		else
			JDBCTemp.rollback(conn);
		JDBCTemp.close(conn);
		return result;
	}

	public Book searchBook(int bid) {
		Book book = new Book();
		Connection conn = JDBCTemp.getConnection();
		book = dao.selectBook(conn, bid);
		
		return book;	
			
		
	}

	public ArrayList<Book> searchBookTitle(String title) {
		ArrayList<Book> list = new ArrayList<>();
		Connection conn = JDBCTemp.getConnection();
		list = dao.searchBookTitle(conn, title);
		return list;
		
	}

	public ArrayList<Book> selectAll() {
		ArrayList<Book> list = new ArrayList<>();
		Connection conn = JDBCTemp.getConnection();
		list = dao.selectAllBooks(conn);
		return list;
	}

	public Book selectBook(int bid) {
		Book book = new Book();
		return null;
	}

	
}
