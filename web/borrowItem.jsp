<%-- 
    Document   : borrowItem
    Created on : 7 nov. 2012, 10:33:07
    Author     : guyader
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enregistrer un emprunt</title>
        <link rel="stylesheet" href="./css/defaultstyle.css" type="text/css" />
    </head>
    <body>
        <header>
            <a href="librarianAccess.jsp">Accueil</a>
            <a href="ListMember">Adh&eacute;rents</a>
            <a href="ListWorks">Ouvrages</a>
            <a href="ListGenres">Genres</a>
            <a href="ListAuthors">Auteurs</a>
            <a href="ListItems">Items</a>
            <a href="borrowItem.jsp" id="current-page">Enregistrer un emprunt</a>
            <a href="returnItem.jsp">Retourner un emprunt</a>
            <a href="ListBorrowings">Emprunts</a>
            <a href="ListBookings">Réservations</a>
        </header>
        
        <div id="wrap-text">
            <h1>Enregistrer un emprunt</h1>
            
            ${requestScope.alert}
            <form action="BorrowItem" method="POST">
                <p>
                    <label for="idItem">ID de l'Item</label>
                    <input type="text" id="idItem" name="idItem"/><br/>
                    
                    <label for="idAdherent">ID de l'Adherent</label>
                    <input type="text" id="idAdherent" name="idAdherent"/><br/>
                    
                    <input type="submit" value="Enregistrer"/>
                </p>
            </form>
        </div>
    </body>
</html>
