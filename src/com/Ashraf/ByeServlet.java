package com.Ashraf;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ByeServlet
 */
@WebServlet("/ByeServlet")
public class ByeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ByeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<h2>Welcome to :: Bye Page </h2>");
		
		Cookie cookies[] = request.getCookies();
		out.println("<h5>Session Tracking using Cookies : </h5><br>");
		for(Cookie c : cookies) {
			out.println("Cookie Name = "+c.getName()+" :: Cookie Value = "+c.getValue()+"<br>");
		}
		
		out.println("<br>");
		String fname =request.getParameter("fname");
		
		out.println("<b>Bye  "+fname+" using hidden form field <br></b>");
		
		out.println("<br>");
		String fullName = request.getParameter("fullname");
		out.println("<b>Bye  "+fullName+" using URL Rewriting <br></b>");

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
