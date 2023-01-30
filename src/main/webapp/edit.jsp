<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="com.entity.Note" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="css_js.jsp" %>
</head>
<body>
  <div class="container">
       <%@include file="navbar.jsp" %>
     <h1>Edit your Note</h1>
     <%
  // int noteid=  Integer.parseInt(request.getParameter("node_id"));
     int  noteid=Integer.parseInt(request.getParameter("note_id").trim());
     
     SessionFactory factory = new Configuration().configure().buildSessionFactory();  
     
     Session session1 = factory.openSession();
     Note note= session1.get(Note.class, noteid);
     
     
     session1.close();
     
     %>
   <form action="UpdateServlet" method="post">
   
   <input value="<%=note.getId()%>" name="noteid" type="hidden">
  <div class="form-group">
    <label for="title">Note Title</label>
    <input required="required" 
    type="text"
     name="title"
      class="form-control" 
      id="title" 
      aria-describedby="emailHelp"
       placeholder="Enter Here"
       value="<%=note.getTitle()  %>">
   
  </div>
  <div class="form-group">
    <label for="content">Content</label>
    <textarea required="required" 
    name="content"
     class="form-control"
     id="content" 
     placeholder="Enter your content here"
     > <%=note.getContent() %></textarea>
  </div>
  
  <div class="conatainer text-center">
  
  <button type="submit" class="btn btn-success">Save your Note</button> 
  </div>
 
</form>
     
    </div>
</body>
</html>