package in.nilayshah.servlet;

import javax.servlet.*;
import javax.servlet.http.*;

import in.nilayshah.bean.Furniture;

public class MyServletContextListener implements ServletContextListener, ServletRequestListener, HttpSessionListener  {
    
    @Override
    public void contextInitialized(ServletContextEvent event){
	ServletContext sc = event.getServletContext();
	String whatType = sc.getInitParameter("typeSelected");
	System.out.println("MyServletContextListener :: contextInitialized() :: furniture type:: "+whatType);
	Furniture f = new Furniture(whatType);
	sc.setAttribute("furniture", f);
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent event){
	ServletContext sc = event.getServletContext();
	String whatType= sc.getAttribute("furniture").toString();
	System.out.println("MyServletContextListener :: contextDestroyed() :: furniture type:: "+whatType);
    }
    
    @Override
    public void requestInitialized(ServletRequestEvent event){
	event.getServletRequest().setAttribute("init-request", "init-request");
	System.out.println("MyServletContextListener :: requestInitialized");
    }
    
    @Override
    public void requestDestroyed(ServletRequestEvent event){
	String initRequest= event.getServletRequest().getAttribute("init-request").toString();
	System.out.println("MyServletContextListener :: requestDestroyed :: value :: "+initRequest);
    }
    
    @Override
    public void sessionCreated(HttpSessionEvent event){
	event.getSession().setAttribute("new-session", "new-session");
	System.out.println("MyServletContextListener :: sessionCreated");
    }
    
    @Override
    public void sessionDestroyed(HttpSessionEvent event){
	String newSession= event.getSession().getAttribute("new-session").toString();
	System.out.println("MyServletContextListener :: sessionDestroyed :: value :: "+newSession);
    }
   
}