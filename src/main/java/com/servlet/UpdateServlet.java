package com.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Note;


public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int noteid  =Integer.parseInt(request.getParameter("noteid").trim());
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			session.beginTransaction();
			
			
			Note note = session.get(Note.class, noteid);
			note.setTitle(title);
			note.setContent(content);
			note.setAddeedDate(new Date());
			session.getTransaction().commit();
			session.close();
			response.sendRedirect("all_note.jsp");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
