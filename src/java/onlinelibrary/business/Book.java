package onlinelibrary.business;

import java.io.Serializable;

public class Book implements Serializable {

	private String bookid;
	private String title;
	private String author;
	private String pubdate;
	private String quantity;

	public Book() {
		title="";
		author="";
		pubdate = "";
		quantity = "";
	}

	public Book(String bookid, String title,String author,String pubdate, String quantity) {
		this.bookid = bookid;
		this.title = title;
		this.author = author;
		this.quantity = quantity;
		this.pubdate = pubdate;
	}

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
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

	public String getPubdate() {
		return pubdate;
	}

	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", title=" + title + ", author=" + author + ", pubdate=" + pubdate
				+ ", quantity=" + quantity + "]";
	}




}