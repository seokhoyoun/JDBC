package book.mvc.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import book.mvc.model.vo.Book;

public class BookDao {
	
	Properties p = new Properties();
	
	public BookDao() {
		try {
			p.load(new FileReader("prop/query.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertBook(Connection conn, Book book) {
		int result = 0;
		String query = p.getProperty("insert");
		try(PreparedStatement ps = conn.prepareStatement(query)){
			/*BOOK_ID	NUMBER
			TITLE	VARCHAR2(50 BYTE)
			AUTHOR	VARCHAR2(20 BYTE)
			PUBLISHER	VARCHAR2(20 BYTE)
			PUBLISH_DATE	DATE
			PRICE	NUMBER*/
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getPublisher());
			ps.setDate(4, book.getDate());
			ps.setInt(5, book.getPrice());
			
			result = ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int updateBook(Connection conn, Book book) {
		int result = 0;
		String query = p.getProperty("update");
		try(PreparedStatement ps = conn.prepareStatement(query)){
			ps.setInt(1, book.getPrice());
			ps.setInt(2, book.getBid());
				result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int deleteBook(Connection conn, int bid) {
		int result = 0;
		String query = p.getProperty("delete");
		try(PreparedStatement ps = conn.prepareStatement(query)){
			ps.setInt(1, bid);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public Book selectBook(Connection conn, int bid) {
		Book b = new Book();
		String query = p.getProperty("selectbid");
		try(PreparedStatement ps = conn.prepareStatement(query)){
			ps.setInt(1, bid);
			try(ResultSet rset = ps.executeQuery()){
				
			if(rset.next()) {
				b.setBid(rset.getInt("book_id"));
				b.setTitle(rset.getString("title"));
				b.setAuthor(rset.getString("author"));
				b.setPublisher(rset.getString("publisher"));
				b.setDate(rset.getDate("publish_date"));
				b.setPrice(rset.getInt("price"));
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public ArrayList<Book> searchBookTitle(Connection conn, String title) {
		ArrayList<Book> list = new ArrayList<>();
		String query = p.getProperty("selectbooktitle");
		try(PreparedStatement ps = createPS(conn, title, query);
				ResultSet rset = ps.executeQuery()){
			while(rset.next()) {
				Book b = new Book();
				b.setBid(rset.getInt("book_id"));
				b.setTitle(rset.getString("title"));
				b.setAuthor(rset.getString("author"));
				b.setPublisher(rset.getString("publisher"));
				b.setDate(rset.getDate("publish_date"));
				b.setPrice(rset.getInt("price"));
				list.add(b);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	private PreparedStatement createPS(Connection conn, String title, String query) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, "%"+title+"%");
		return ps;
	}

	public ArrayList<Book> selectAllBooks(Connection conn) {
		ArrayList<Book> list = new ArrayList<>();
		String query = p.getProperty("selectall");
		try(Statement stmt = conn.createStatement();
				ResultSet rset = stmt.executeQuery(query)){
			while(rset.next()) {
				Book b = new Book();
				b.setBid(rset.getInt("book_id"));
				b.setTitle(rset.getString("title"));
				b.setAuthor(rset.getString("author"));
				b.setPublisher(rset.getString("publisher"));
				b.setDate(rset.getDate("publish_date"));
				b.setPrice(rset.getInt("price"));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
