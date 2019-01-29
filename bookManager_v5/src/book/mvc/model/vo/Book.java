package book.mvc.model.vo;

import java.sql.Date;

public class Book {
	private int bid;
	private String title;
	private String author;
	private String publisher;
	private Date date;
	private int price;
	
	public Book() {
	}

	public Book(int bid, String title, String author, String publisher, Date date, int price) {
		super();
		this.bid = bid;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.date = date;
		this.price = price;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return bid + "\t" + title + "\t" + author + "\t" + publisher + "\t" + date + "\t" + price;
	}
	
	
}
