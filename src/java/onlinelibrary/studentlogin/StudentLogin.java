package onlinelibrary.studentlogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import onlinelibrary.business.Book;
import onlinelibrary.data.BookDB;
import onlinelibrary.data.IssueDB;
import onlinelibrary.util.PasswordUtil;

@WebServlet("/StudentLogin")

public class StudentLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NullPointerException {
            
                        String url = "/studentLogin.jsp";

                        String username=request.getParameter("username");
			String pass=request.getParameter("password");

                        /*
			// check strength requirements
			String message;
			try {
				PasswordUtil.checkPasswordStrength(pass);
				message = "";
			} catch (Exception e) {
				message = e.getMessage();
			}
			request.setAttribute("message", message);
                        */
			if(LoginDaoStudent.getName(username, pass) != null) {
				HttpSession session = request.getSession(true);
				ArrayList<Book> bookslist = new ArrayList<Book>();
				bookslist = BookDB.selectBooks();


				request.setAttribute("book", bookslist);
				//request.setAttribute("book", issuelist);

				url = "/studentDashboard.jsp";
                                
                              getServletContext().getRequestDispatcher(url).forward(request, response);

			}
			else {
				PrintWriter out=response.getWriter();
				out.println("<script>window.location=\"studentLogin.jsp\";alert(\"Student Username Or Password Is Incorrect ...!\")</script>");
			}
			
	}

}
