<%-- 
    Document   : returnItem
    Created on : 13 nov. 2012, 09:22:55
    Author     : guyader
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JRetourner un Emprunt</title>
        <link rel="stylesheet" href="./css/defaultstyle.css" type="text/css" />
    </head>
    <body><header>
            <a href="librarianAccess.jsp">Accueil</a>
            <a href="ListMember">Adh&eacute;rents</a>
            <a href="ListWorks">Ouvrages</a>
            <a href="ListGenres">Genres</a>
            <a href="ListAuthors">Auteurs</a>
            <a href="ListItems">Items</a>
            <a href="borrowItem.jsp">Enregistrer un emprunt</a>
            <a href="returnItem.jsp" id="current-page">Retourner un emprunt</a>
            <a href="ListBorrowings">Emprunts</a>
            <a href="ListBookings">Réservations</a>
        </header>
    
        <div id="wrap-text">
            <h1>Retourner un Emprunt</h1>
            <form action="ReturnItem" method="POST">
                <p>
                    <label for="idItem">ID de l'Item </label><input type="text" id="idItem" name="idItem"/><br/>
                    <input type="submit" value="Retourner"/>
                </p>
            </form>
        </div>
    </body>
</html>
