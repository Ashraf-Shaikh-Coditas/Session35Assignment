package com.Ashraf;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String password = request.getParameter("password");
		
		Cookie ck = new Cookie("fnamecookie",fname);
		ck.setMaxAge(1800);
		response.addCookie(ck);
		
		ck = new Cookie("lnamecookie",lname);
		response.addCookie(ck);
		
		ck = new Cookie("passwordcookie",password);
		response.addCookie(ck);
		
	
		
		if(password.equals(fname+"@123")) {
//			RequestDispatcher rd = request.getRequestDispatcher("WelcomeServlet");
//			rd.forward(request, response);
		
			out.println("<h2>Welcome to Login Page</h2>");
			out.println("<form action='WelcomeServlet' method='post'>");
			out.println("<input type='hidden' name ='fname' value='"+fname+"'>");
			out.println("<input type='submit' value='GO'>");
			out.println("</form>");
			
			out.println("<a href='WelcomeServlet'>Link to Welcome Page</a><br>");		

			
			
		} else {
			out.print("<h2 style=\"color:red\">Invalid Credentials </h2>");
			RequestDispatcher rd = request.getRequestDispatcher("Index.html");
			rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
