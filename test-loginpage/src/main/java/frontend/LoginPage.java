package frontend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import backend.User;
import backend.UserRepository;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserRepository repo = UserRepository.getInstance();
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User u = repo.getUser(username, password);
		response.getWriter().println(u == null ? error() : home(u));
	}
	
	private String error( ) {
		return "<html><body><p>errore</p></body></html>";
	}
	
	private String home(User u) {
		return "<html><body><p>benvenuto " + u.getFullname()+ "</p></body></html>";
	}

}