package onlinelibrary.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import onlinelibrary.business.Book;
import onlinelibrary.business.Issue;

public class IssueDB {

	public static int insert(Issue issue) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;

		String query = "INSERT INTO issue (bookid, studentid) "
				+ "VALUES (?, ?)";
		try {

			ps = connection.prepareStatement(query);
			ps.setString(1, issue.getBookid());
			ps.setString(2, issue.getStudentid());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			return 0;
		} finally {
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
	}

	public static ArrayList<Book> issuedBooks(String studentid) {
		// add code that returns an ArrayList<User> object of all books in the
		// Book table
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		//int sid= Integer.valueOf(studentid);
		String query = "SELECT * FROM Book inner join Issue on Book.bookid= Issue.bookid where Issue.studentid= ? ;";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1,studentid);
			System.out.println(studentid);
			rs = ps.executeQuery();
			ArrayList<Book> books = new ArrayList<Book>();
			while (rs.next()) {
				Book book = new Book();
				book.setBookid(rs.getString("bookid"));

				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPubdate(rs.getString("publicationdate"));
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

	public static int delete(Issue issue) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;

		String query = "DELETE FROM Issue "
				+ "WHERE bookid = ?";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, issue.getBookid());

			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			return 0;
		} finally {
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
	}

	public static int deleteWithBookId(String bookId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;

		String query = "DELETE FROM Issue "
				+ "WHERE bookid = ?";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, bookId);

			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			return 0;
		} finally {
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
	}

}




