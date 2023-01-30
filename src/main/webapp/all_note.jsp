<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.entity.*" %>
<%@ page isELIgnored = "false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Notes</title>
 <%@include file="css_js.jsp" %>
</head>
<body>
 <div class="container">
       <%@include file="navbar.jsp" %>
     <h2>All Notes:</h2>
     
     
     <div class="row">
       <div class="col-12">
       
        <%
     SessionFactory factory = new Configuration().configure().buildSessionFactory();
     //Session s= FactoryProvider.getFactory().openSession();
 	
 	Session session1 = factory.openSession();
 	
 Query q=	session1.createQuery("from Note");
      List<Note>  list=     q.list();
    for(Note note:list){
    	//out.println(note.getId()+":"+note.getTitle()+"<br/>");
    
    %>
    
    <div class="card mt-3" >
  
  <div class="card-body px-5">
    <h5 class="card-title"><%=note.getTitle() %></h5>
    <p class="card-text"><%= note.getContent() %></p>
    <div class="container mt-3">
    <a href="DeleteServlet?note_id=<%=note.getId() %> "class="btn btn-danger">Delete</a>
    <a href="edit.jsp?note_id=<%=note.getId() %>" class="btn btn-primary">Update</a>
    </div>
  </div>
</div>
    
    	
 <%  
    }
    session1.close();
     %>
       </div>
      </div>
     
     
    
     
     
    </div>
</body>
</html>