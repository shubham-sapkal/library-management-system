package onlinelibrary.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import onlinelibrary.business.Book;
import onlinelibrary.data.BookDB;

@WebServlet("/AddBook")
public class AddBook extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		String url = "/index.html";

		// get current action
		String action = request.getParameter("action");

		if (action == null) {
			action = "join";  // default action
		}

		// perform action and set URL to appropriate page
		if (action.equals("join")) {
			url = "/index.jsp";    // the "join" page
		}
		else if (action.equals("add")) {

			System.out.println("enetres add");
			// get parameters from the request
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String pubdate = request.getParameter("pubdate");
			String quantity = request.getParameter("quantity");
			String bookid = request.getParameter("bookid");
			HttpSession session = request.getSession(true);
			session.setAttribute("bookid",bookid);
			System.out.println("book id is "+ session.getAttribute("bookid"));

			// store data in User object
			Book book = new Book(bookid, title, author, pubdate, quantity);

			// validate the parameters
			String message;

			{    message = "The book has been successfully added";
			url = "/result.jsp";
			BookDB.insert(book);
			}
			request.setAttribute("book", book);
			request.setAttribute("message", message);
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