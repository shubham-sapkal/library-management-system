package onlinelibrary.studentlogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import onlinelibrary.data.ConnectionPool;
import onlinelibrary.data.DBUtil;

public class LoginDaoStudent {
    
	public static String getName(String username,String password,HttpServletRequest request) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs= null;
		String name= null;
		String existingpass=null;
                String studentid = null;
                HttpSession session = request.getSession(true);
                
		//String salt;
		//String newpwd;
		String query = "SELECT * FROM student WHERE username = ? AND password = ?";
		try {
			ps = connection.prepareStatement(query);
                        ps.setString(1,username);
                        ps.setString(2, password);
                        rs= ps.executeQuery();
                        while(rs.next()){
                            name = username;
                            existingpass = rs.getString("password");
                            studentid = rs.getString("studentid");
                                            
                        }
			System.out.println("password = "+existingpass);
			System.out.println("studentid = "+studentid);
			
                        session.setAttribute("studentid", studentid);
                        
                        
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
