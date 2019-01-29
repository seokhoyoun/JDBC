package book.mvc.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import book.mvc.exception.BookException;
import book.mvc.model.dao.BookDao;
import book.mvc.model.vo.Book;
import common.JDBCTemp;
public class BookService {
	
	private BookDao dao;
	
	public BookService() throws BookException {
		 dao = new BookDao();
	}
	
	public int insertBook(Book book) throws BookException {
		Connection conn = JDBCTemp.getConnection();
		int result = dao.insertBook(conn, book);
		if(result > 0)
			JDBCTemp.commit(conn);
		JDBCTemp.close(conn);
		return result;
	}

	public int updateBook(Book book) throws BookException {
		Connection conn = JDBCTemp.getConnection();
		int result = dao.updateBook(conn, book);
		if(result > 0)
			JDBCTemp.commit(conn);
		JDBCTemp.close(conn);
		return result;
		
	}

	public int deleteBook(int bid) throws BookException {
		Connection conn = JDBCTemp.getConnection();
		int result = dao.deleteBook(conn, bid);
		if(result > 0)
			JDBCTemp.commit(conn);
		JDBCTemp.close(conn);
		return result;
	}

	public Book searchBook(int bid) throws BookException {
		Book book = new Book();
		Connection conn = JDBCTemp.getConnection();
		book = dao.selectBook(conn, bid);
		
		return book;	
			
		
	}

	public ArrayList<Book> searchBookTitle(String title) throws BookException {
		ArrayList<Book> list = new ArrayList<>();
		Connection conn = JDBCTemp.getConnection();
		list = dao.searchBookTitle(conn, title);
		return list;
		
	}

	public ArrayList<Book> selectAll() throws BookException {
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
