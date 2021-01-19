package onlinelibrary.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import onlinelibrary.business.Book;

public class BookDB {

	public static int insert(Book book) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;

		String query = "INSERT INTO book (bookid, title , author, pubdate, quantity) "
				+ "VALUES (?, ?, ?, ?, ?)";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, book.getBookid());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getAuthor());
			ps.setString(4, book.getPubdate());
			ps.setString(5, book.getQuantity());
			return ps.executeUpdate();
		} catch (SQLException e) { 
			System.out.println(e);
			return 0;
		} finally {
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
	}

	public static ArrayList<Book> selectBooks() {
		// add code that returns an ArrayList<User> object of all books in the
		// Book table
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * FROM Book ";
		try {
			ps = connection.prepareStatement(query);

			rs = ps.executeQuery();
			ArrayList<Book> books = new ArrayList<Book>();
			while (rs.next()) {
				Book book = new Book();
				book.setBookid(rs.getString("bookid"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPubdate(rs.getString("publicationdate"));
				book.setQuantity(rs.getString("quantity"));
				books.add(book);
			}
			return books;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
	}

	public static int update(Book book) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;

		String query = "UPDATE Book SET "
				+ "title = ? ,"
				+ "author = ? ,"
				+ "publicationdate = ? ,"
				+ "quantity = ? "
				+" WHERE bookid = ?";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getPubdate());
			ps.setString(4, book.getQuantity());
			ps.setString(5, book.getBookid());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			return 0;
		} finally {
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
	}

	public static int delete(Book book) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;

		String query = "DELETE FROM Book "
				+ "WHERE bookid = ?";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, book.getBookid());

			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			return 0;
		} finally {
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
	}

	public static Book selectBook(String bookid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * FROM Book "
				+ "WHERE bookid = ?";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, bookid);
			rs = ps.executeQuery();
			Book book = null;
			while(rs.next()) {

				book = new Book();
				book.setBookid(bookid);

			}

			return book;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
	}

}