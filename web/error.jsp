<%-- 
    Document   : error
    Created on : 10 nov. 2012, 14:15:50
    Author     : guyader
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erreur <%= request.getParameter("title") %></title>
    </head>
    <body>
        <h1>Erreur <%= request.getParameter("title") %></h1>
        <p><%= request.getParameter("message") %></p>
    </body>
</html>
