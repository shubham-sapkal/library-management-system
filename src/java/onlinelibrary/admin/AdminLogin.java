package onlinelibrary.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import onlinelibrary.data.ConnectionPool;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("adminName");
		String pass=request.getParameter("password");
		PrintWriter out=response.getWriter();
                
                ConnectionPool pool = ConnectionPool.getInstance();
                Connection connection = pool.getConnection();
                PreparedStatement ps = null;
                
                String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";
                
                
                try{
                    
                    ps = connection.prepareStatement(sql);
                    ps.setString(1, name);
                    ps.setString(2, pass);
                    
                    ResultSet rs = ps.executeQuery();

                    //System.out.println(rs.next());
                    //System.out.println("Username = "+rs.getString("username")+"\n password = "+rs.getString("password"));
                    
                    if(rs.next()){
                    
                        HttpSession adminSession=request.getSession(true);
                        adminSession.setAttribute("adminName", "Admin");
                        System.out.println("Login Sucessfull!!");
                        request.getRequestDispatcher("/adminDashboard.jsp").forward(request, response);
                    }
                    else{        
                        
                            out.println("<script>window.location=\"adminLogin.jsp\";alert(\"Admin Name Or Password Is Incorrect ...!\")</script>");          
                    
                    }
                    
                }
                catch(SQLException sqlE){
                    System.out.println("SQL EXCEPTION OCCURS!!" + sqlE);
                }
                
                
                
		

		out.close();
	}


}
