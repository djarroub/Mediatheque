<%-- 
    Document   : more
    Created on : 10 nov. 2012, 16:53:58
    Author     : guyader
--%>

<%@page import="java.lang.reflect.Method"%>
<%@page import="java.lang.reflect.Field"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="enterprise.ProjetMediatheque.entity.Ouvrage"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! Ouvrage ouvrage; %>
<% ouvrage = (Ouvrage) request.getAttribute("ouvrage"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Plus d'infos sur ${ouvrage.titre}</title>
        <link rel="stylesheet" href="./css/defaultstyle.css" type="text/css" />
    </head>
    <body>
        <header>
            <a href="librarianAccess.jsp">Accueil</a>
            <a href="ListMember">Adh&eacute;rents</a>
            <a href="ListWorks" id="current-page">Ouvrages</a>
            <a href="ListGenres">Genres</a>
            <a href="ListAuthors">Auteurs</a>
            <a href="ListItems">Items</a>
            <a href="borrowItem.jsp">Enregistrer un emprunt</a>
            <a href="returnItem.jsp">Retourner un emprunt</a>
            <a href="ListBorrowings">Emprunts</a>
            <a href="ListBookings">Réservations</a>
        </header>
    
        <div id="wrap-text">
            <h1>Plus d'infos sur ${ouvrage.titre}</h1>
            <p>
                ${ouvrage.toString()}
            </p>
        </div>
    </body>
</html>
