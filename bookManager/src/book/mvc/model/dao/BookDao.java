package book.mvc.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import book.mvc.model.vo.Book;

public class BookDao {

	public int insertBook(Book book) {
		int result = 0;
		String query = "insert into tb_book values (seq_bid.nextval, '"+book.getTitle()+"','"+ book.getAuthor()+"','"+
				book.getPublisher()+"','"+book.getDate()+"',"+book.getPrice()+")";
		try(Connection conn =
				DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
					Statement stmt = conn.createStatement();){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn.setAutoCommit(false);
			result = stmt.executeUpdate(query);
			if(result > 0)
				conn.commit();
			else
				conn.rollback();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int updateBook(Book book) {
		int result = 0;
		String query = "update tb_book set price = "+book.getPrice()+"where book_id = "+book.getBid();
		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
				Statement stmt = conn.createStatement();){
				conn.setAutoCommit(false);
				Class.forName("oracle.jdbc.driver.OracleDriver");
				result = stmt.executeUpdate(query);
				if(result > 0) 
					conn.commit();
				else
					conn.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int deleteBook(int bid) {
		int result = 0;
		String query = "delete tb_book where book_id = "+bid;
		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
				Statement stmt = conn.createStatement();){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn.setAutoCommit(false);
			result = stmt.executeUpdate(query);
			if(result > 0)
				conn.commit();
			else
				conn.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public Book selectBook(int bid) {
		Book b = new Book();
		String query = "select * from tb_book where book_id = "+bid;
		try(ResultSet rset = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student").createStatement().executeQuery(query)){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			if(rset.next()) {
				b.setBid(rset.getInt("book_id"));
				b.setTitle(rset.getString("title"));
				b.setAuthor(rset.getString("author"));
				b.setPublisher(rset.getString("publisher"));
				b.setDate(rset.getDate("publish_date"));
				b.setPrice(rset.getInt("price"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public ArrayList<Book> searchBookTitle(String title) {
		ArrayList<Book> list = new ArrayList<>();
		Book b = new Book();
		String query = "select * from tb_book where title like '%"+title+"%'";
		try(ResultSet rset = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student").createStatement().executeQuery(query)){
			while(rset.next()) {
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

	public ArrayList<Book> selectAllBooks() {
		ArrayList<Book> list = new ArrayList<>();
		String query = "select * from tb_book";
		Book b = new Book();
		try(ResultSet rset = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student").createStatement().executeQuery(query)){
			while(rset.next()) {
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
