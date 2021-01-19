package onlinelibrary.studentlogin;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import onlinelibrary.data.ConnectionPool;
import onlinelibrary.data.DBUtil;
import onlinelibrary.util.PasswordUtil;

public class LoginDaoStudent {
	public static String getName(String username,String hashedpwd) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs= null;
		String name= null;
		String existingpass;
		String salt;
		String newpwd;
		String query
		= "SELECT * from Student WHERE username='"+username+"' ;";
		try {
			ps = connection.prepareStatement(query);{
				rs= ps.executeQuery();
				while(rs.next()){
					name= rs.getString("firstname");
					existingpass= rs.getString("password");
					salt= rs.getString("salt");
					try {
						newpwd= PasswordUtil.hashPassword(hashedpwd + salt);
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return name;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		} finally {
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
	}
}
