<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Note</title>
    <%@include file="css_js.jsp" %>



</head>
<body>
  <div class="container">
       <%@include file="navbar.jsp" %>
    <h1>Please fill your note details</h1>
    <br>
    <form action="SaveNoteServlet" method="post">
  <div class="form-group">
    <label for="title">Note Title</label>
    <input required="required" type="text" name="title" class="form-control" id="title" aria-describedby="emailHelp" placeholder="Enter Here">
   
  </div>
  <div class="form-group">
    <label for="content">Content</label>
    <textarea required="required" name="content" class="form-control" id="content" placeholder="Enter your content here"></textarea>
  </div>
  
  <div class="conatainer text-center">
  
  <button type="submit" class="btn btn-primary">Add</button> 
  </div>
 
</form>
    </div>
    
    
    
</body>
</html>