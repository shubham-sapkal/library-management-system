package onlinelibrary.studentlogin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import onlinelibrary.business.Issue;
import onlinelibrary.data.IssueDB;

@WebServlet("/IssueServlet")
public class IssueServlet extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		String url = "/index.html";

		// get current action
		boolean issue = request.getParameter("issue") != null;
		boolean remove = request.getParameter("remove") != null;
		HttpSession session = request.getSession(true);
                
                System.out.println("Username = "+session.getAttribute("studentid"));

		if (issue) {

			String bookid = request.getParameter("bookid");
			System.out.println("My book"+ bookid);
			String studentid = (String) session.getAttribute("studentid");
			Issue issue1 = new Issue(bookid,studentid);

			//response.sendRedirect("/viewBooks.jsp");
			url = "/viewBooks.jsp";
			IssueDB.insert(issue1);


		} else if (remove) {
			String bookid = request.getParameter("bookid");
			String studentid = (String) session.getAttribute("studentid");
			Issue issue1 = new Issue(bookid,studentid);
			url = "/viewBooks.jsp";
			IssueDB.delete(issue1);
		}
		getServletContext()
		.getRequestDispatcher(url)
		.forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
}