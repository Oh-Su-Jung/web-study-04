package web_study_04.unit01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Appcontext")
public class Appcontext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procssRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procssRequest(request, response);
	}

	private void procssRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = getServletContext();
		
		String resourcePath = application.getInitParameter("noticePath");
		String str = "";
		URL url = application.getResource(resourcePath);
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(url.openStream()))){
			while((str = br.readLine()) != null){
				System.out.println(str);
			}
		} catch (IOException e){
			System.out.println("예외 발생"+ e.getMessage());
		}
	}

}
