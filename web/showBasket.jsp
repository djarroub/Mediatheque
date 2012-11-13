<%-- 
    Document   : index
    Created on : 10 nov. 2012, 10:23:59
    Author     : guyader
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <a href="ShowBasket" id="current-page">Panier</a>
        </header>

        <div id="wrap-text">
            <h1>Bienvenue sur le catalogue en ligne de la Médiathèque</h1>
            <table>
                <thead>
                    <tr>
                        <th scope="col">Type</th>
                        <th scope="col">Titre</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <c:forEach var="ouvrage" begin="0" items="${requestScope.ouvrages}">
                    <tr>
                        <td>${ouvrage.type.getNom()}</td>
                        <td>${ouvrage.titre}</td>
                        <td><a href="DropBasket?idOuvrage=${ouvrage.id}">Enlever</a></td>
                    </tr>
                </c:forEach>
            </table>
            <form action="ValidateBasket" method="POST">
                <input type="submit" value="Reserver"/>
            </form>
        </div>
    </body>
</html>
