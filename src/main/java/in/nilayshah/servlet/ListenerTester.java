package in.nilayshah.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import in.nilayshah.bean.Furniture;

public class ListenerTester extends HttpServlet implements Servlet {

    public ListenerTester() {
	super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter pw = response.getWriter();
	pw.println("context attributes set by the listener <br>");
	Furniture f = (Furniture)getServletContext().getAttribute("furniture");
	pw.println("The furniture you have selected is :" + f.getWhatType());
	System.out.println("ListenerTester :: furniture type:: "+f.getWhatType());
	request.getSession().setAttribute("hello", "hello");
	
	response.sendRedirect("/JavaGuideByNilay/homepage");
    } 

    public void doPost(HttpServletRequest request, 
	    HttpServletResponse response) throws ServletException, IOException {
    } 
}