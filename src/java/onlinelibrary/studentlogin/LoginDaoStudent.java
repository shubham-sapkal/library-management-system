package onlinelibrary.studentlogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import onlinelibrary.data.ConnectionPool;
import onlinelibrary.data.DBUtil;

public class LoginDaoStudent {
    
	public static String getName(String username,String password) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs= null;
		String name= null;
		String existingpass;
		//String salt;
		//String newpwd;
		String query = "SELECT * FROM student WHERE username = ? AND password = ?";
		try {
			ps = connection.prepareStatement(query);
                        ps.setString(1,username);
                        ps.setString(2, password);
                        rs= ps.executeQuery();
                        while(rs.next()){
                            name= rs.getString("firstname");
                            existingpass= rs.getString("password");
                                            
                        }
			
			
                        
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		} finally {
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
                
                return name;
	}
}
