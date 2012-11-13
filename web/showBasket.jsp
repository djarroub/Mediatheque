<%-- 
    Document   : index
    Created on : 10 nov. 2012, 10:23:59
    Author     : guyader
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% if (session == null || session.getAttribute("adherent") == null) response.sendRedirect("index.jsp"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenue sur le catalogue en ligne de la Médiathèque</title>
        <link rel="stylesheet" href="./css/defaultstyle.css" type="text/css" />
    </head>
    <body>
        <header>
            <a href="index.jsp">Accueil</a>
            <a href="BrowseCatalog">Catalogue</a>
            <a href="showBasket.jsp" id="current-page">Panier</a>
        </header>

        <div id="wrap-text">
            <h1>Bienvenue sur le catalogue en ligne de la Médiathèque</h1>
            
        </div>
    </body>
</html>
