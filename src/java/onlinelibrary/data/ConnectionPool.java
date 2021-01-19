package onlinelibrary.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionPool {



	private static ConnectionPool pool = null;
	//private static DataSource dataSource = null;

	private ConnectionPool() {	
	}

	public static synchronized ConnectionPool getInstance() {
		if (pool == null) {
			pool = new ConnectionPool();
		}
		return pool;
	}

	public Connection getConnection() {
		Connection con = null;
		
		try
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			con = DriverManager.getConnection("jdbc:mysql://localhost/onlinelibrary","root","");
			System.out.println("Post establishing a DB connection - "+con);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return con;
		
	}
	public void freeConnection(Connection c) {
		try {
			c.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}