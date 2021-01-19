package onlinelibrary.email;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onlinelibrary.util.EmailUtility;

@WebServlet("/EmailSendingServlet")
public class EmailSendingServlet extends HttpServlet {
	private String host;
	private String port;
	private String user;
	private String pass;

	@Override
	public void init() {
		// reads SMTP server setting from web.xml file
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// reads form fields
		String recipient = request.getParameter("recipient");
		String subject ="Books Issued From the Online Library";
		Date date=new java.util.Date();
		System.out.println(date);
		String content = "You have Issued the following books on:"+date;

		String resultMessage = "";

		try {
			EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
					content);
			resultMessage = "The e-mail was sent successfully";
		} catch (Exception ex) {
			ex.printStackTrace();
			resultMessage = "There were an error: " + ex.getMessage();
		} finally {
			request.setAttribute("Message", resultMessage);
			getServletContext().getRequestDispatcher("/emailSent.jsp").forward(
					request, response);
		}
	}
}