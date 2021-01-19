package onlinelibrary.register;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import onlinelibrary.business.Student;
import onlinelibrary.data.StudentDB;
import onlinelibrary.util.PasswordUtil;

@WebServlet("/StudentRegister")
public class StudentRegister extends HttpServlet {


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
			// get parameters from the request
			String firstName = request.getParameter("firstname");
			String lastName = request.getParameter("lastname");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String sid = request.getParameter("sid");
			HttpSession session = request.getSession(true);
			session.setAttribute("studentid",sid);
			System.out.println("student id is "+ session.getAttribute("studentid"));

			// check strength requirements
			String message1;
			try {
				PasswordUtil.checkPasswordStrength(password);
				message1 = "";
			} catch (Exception e) {
				message1 = e.getMessage();
			}
			request.setAttribute("message", message1);

			// hash and salt password
			String hashedPassword;
			String salt = "";
			String saltedAndHashedPassword;
			try {
				hashedPassword = PasswordUtil.hashPassword(password);
				salt = PasswordUtil.getSalt();
				saltedAndHashedPassword = PasswordUtil.hashAndSaltPassword(password);

			} catch (NoSuchAlgorithmException ex) {
				hashedPassword = ex.getMessage();
				saltedAndHashedPassword = ex.getMessage();
			}
			request.setAttribute("hashedPassword", hashedPassword);
			request.setAttribute("salt", salt);
			request.setAttribute("saltedAndHashedPassword", saltedAndHashedPassword);

			// store data in User object
			Student user = new Student(sid, username, saltedAndHashedPassword, firstName, lastName, email,salt);

			System.out.println("salt before saving " + user);

			// validate the parameters
			String message;

			{    message = "";
			url = "/thanks.jsp";
			StudentDB.insert(user);
			}
			request.setAttribute("user", user);
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