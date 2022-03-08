package com.Ashraf;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<h3>Hi Welcome to :: Welcome Page </h3><br>");
		
		String fname =request.getParameter("fname");
		
		out.println("Welcome "+fname+" using hidden form field <br>");
		
		out.println("<form action='ByeServlet' id=form1>" );
		out.println("<input type='hidden' name ='fname' value='"+fname+"'>");
		out.println("<input type='submit' value='GO'>");
		out.println("</form>");
		
//		out.println("<script>");
//		out.println("document.getElementById('form1').submit();");
//		out.println("</script>");
		
		out.println("<a href='ByeServlet'>Link to Bye Page</a><br>");		
		
		out.println("<a href='ByeServlet?fullname="+fname+"'>Link to Bye Page using URL Rewriting</a><br>");

		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
