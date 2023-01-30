package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Note;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		int  noteid=Integer.parseInt(request.getParameter("note_id").trim());
	
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	Session session = factory.openSession();
	
	session.beginTransaction();
	
	Note note= session.get(Note.class, noteid);
	session.delete(note);
	
	session.getTransaction().commit();
	
	session.close();
	factory.close();
	response.sendRedirect("all_note.jsp");
	}catch (Exception e) {
 e.printStackTrace();
	}
	
		
	}

	
}
