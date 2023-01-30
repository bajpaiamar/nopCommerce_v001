package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Note;

/**
 * Servlet implementation class SaveNoteServlet
 */
public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
  
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
	String title=		request.getParameter("title");
	String content=		request.getParameter("content");
	
	Note note= new Note(0, title, content, new Date());
	//System.out.println(note.getId()+":"+note.getTitle());
	
	//hibernate save
	
	
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	
	Session session = factory.openSession();
	
	
	
	session.beginTransaction();
	session.save(note);
	
	session.getTransaction().commit();
	
	session.close();
	factory.close();
	
	response.setContentType("text/html");
	PrintWriter  out= response.getWriter();
	out.println("<h1 style='text-align:center;'>added success</h1>");
	out.println("<h1 style='text-align:center;'><a href='all_note.jsp'>view all Notes</a></h1>");
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
