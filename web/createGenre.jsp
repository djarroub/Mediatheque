<%-- 
    Document   : CreateGenre
    Created on : 10 nov. 2012, 15:00:50
    Author     : sbai
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajouter un nouveau Genre</title>
        <link rel="stylesheet" href="./css/defaultstyle.css" type="text/css" />
    </head>
    <body>
        <header>
            <a href="librarianAccess.jsp">Accueil</a>
            <a href="ListMember">Adh&eacute;rents</a>
            <a href="ListWorks">Ouvrages</a>
            <a href="ListGenres" id="current-page">Genres</a>
            <a href="ListAuthors">Auteurs</a>
            <a href="borrowItem.jsp">Enregistrer un emprunt</a>
            <a href="returnItem.jsp">Retourner un emprunt</a>
            <a href="ListBorrowings">Emprunts</a>
            <a href="ListBookings">Réservations</a>
        </header>
    
        <div id="wrap-text">
            <h1>Ajouter un nouveau Genre</h1>
            <form action="CreateGenre" method=""POST">
                <p>
                    <label for="nomGenre">Nom du Genre </label><input type="text" id = "nomGenre" name="nomGenre" />
                    <input type="submit" value="Ajouter" />
                </p>
            </form>
        </div>
    </body>
</html>