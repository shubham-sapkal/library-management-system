package onlinelibrary.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onlinelibrary.business.Book;
import onlinelibrary.data.BookDB;
import onlinelibrary.data.IssueDB;

@WebServlet("/DeleteBook")
public class DeleteBook extends HttpServlet {


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
		else if (action.equals("delete")) {

			System.out.println("enetres delete");
			// get parameters from the request
			String bookid = request.getParameter("bookid");
			System.out.println("");
			// validate the parameters
			String message;

			{    message = "The book has been successfully deleted";
			url = "/deleteBook.jsp";
			Book book= BookDB.selectBook(bookid);

			IssueDB.deleteWithBookId(bookid);
			BookDB.delete(book);
			}
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