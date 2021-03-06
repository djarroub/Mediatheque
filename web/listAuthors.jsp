<%-- 
    Document   : listAuthors
    Created on : 12 nov. 2012, 22:35:26
    Author     : guyader
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des auteurs</title>
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <link rel="stylesheet" href="./css/defaultstyle.css" type="text/css" />
    </head>
    <body>
        <header>
            <a href="librarianAccess.jsp">Accueil</a>
            <a href="ListMember">Adh&eacute;rents</a>
            <a href="ListWorks">Ouvrages</a>
            <a href="ListGenres">Genres</a>
            <a href="ListAuthors" id="current-page">Auteurs</a>
            <a href="ListItems">Items</a>
            <a href="borrowItem.jsp">Enregistrer un emprunt</a>
            <a href="returnItem.jsp">Retourner un emprunt</a>
            <a href="ListBorrowings">Emprunts</a>
            <a href="ListBookings">Réservations</a>
        </header>

        <div id="wrap-text">
            <h1>Liste des Auteurs</h1>
            <a href="createAuthor.jsp">+ Ajouter un nouvel Auteur.</a>
            <table>
                <thead>
                    <tr class="title">
                        <th scope="col">Prénom</th>
                        <th scope="col">Nom</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="auteur" begin="0" items="${requestScope.auteurs}">
                        <tr class="content">
                            <td>${auteur.prenom}</td>
                            <td>${auteur.nom}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
