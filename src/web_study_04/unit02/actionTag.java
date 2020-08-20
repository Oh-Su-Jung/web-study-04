package web_study_04.unit02;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/actionTag")
public class actionTag extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userID");
		String userPwd = request.getParameter("userPwd");
		String loginCheck = request.getParameter("loginCheck");
		
		request.setAttribute("userID", userID);
		
		RequestDispatcher dispatcher = null;
		if (loginCheck.contentEquals("user")) {
			request.setAttribute("userName", "傈绊按");
			dispatcher = request.getRequestDispatcher("09_servlet_userMain.jsp");
		} else {
			request.setAttribute("userName", "己包府");
			dispatcher = request.getRequestDispatcher("09_servlet_managerMain.jsp");
		}
		
		dispatcher.forward(request, response);
		
	}

}
