<%-- 
    Document   : createAuthor
    Created on : 12 nov. 2012, 22:28:43
    Author     : guyader
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajouter un nouvel Auteur</title>
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
            <h1>Ajouter un nouvel Auteur</h1>
            <form action="CreateAuthor" method="POST">
                <p>
                    <label for="nomAuteur">Nom de l'Auteur</label><input type="text" id = "nomAuteur" name="nom" /><br/>
                    <label for="prenomAuteur">Prénom de l'Auteur</label><input type="text" id = "prenomAuteur" name="prenom" />
                    <input type="submit" value="Ajouter" />
                </p>
            </form>
        </div>
    </body>
</html>