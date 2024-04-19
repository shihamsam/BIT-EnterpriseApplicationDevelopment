package com.shiham.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CatalogServlet
 */
@WebServlet("/CatalogServlet")
public class CatalogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatalogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Name : ").append(request.getParameter("name"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("productName");
		String manufacturer = request.getParameter("manufacturer");
		String sku = request.getParameter("sku");
		
		Catalog.addItem(new CatalogItem(name, manufacturer, sku));
		
		response.setHeader("someHeader", "someHeaderValue");
		response.addCookie(new Cookie("someCookie", "someCookieValue"));
		
		
		PrintWriter out = response.getWriter();
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
		
		out.println("</head>");
		out.println("<body>");
		
		out.println("<h1>Products (" + Catalog.Count() + ")</h1>");
		
		
		out.println("<table class=\"table\">");
		
		out.println("<tbody>");
		
		for (CatalogItem item : Catalog.getItems()) {
			 
			out.println("<tr>");
			out.println("<td>");
			out.println(item.getName());
			out.println("</td>");
			out.println("<td>");
			out.println(item.getSku());
			out.println("</td>");
			out.println("<td>");
			out.println(item.getManufacturer());
			out.println("</td>");
			out.println("</tr>");
			
		}
		out.println("</tbody>");
		out.println("</table>");
		
		out.println("</body>");
		out.println("<html>");
		
		
		out.println("<a class=\"btn btn-primary\" href=\"form.html\"> Create Another</a>");
		

	}

}
