<%-- 
    Document   : createItem
    Created on : 13 nov. 2012, 20:44:58
    Author     : Gilles
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajout d'un nouvel Item</title>
        <link rel="stylesheet" href="./css/defaultstyle.css" type="text/css" />
    </head>
    <body>
        <header>
            <a href="librarianAccess.jsp">Accueil</a>
            <a href="ListMember">Adh&eacute;rents</a>
            <a href="ListWorks">Ouvrages</a>
            <a href="ListGenres">Genres</a>
            <a href="ListAuthors">Auteurs</a>
            <a href="ListItems" id="current-page">Items</a>
            <a href="borrowItem.jsp">Enregistrer un emprunt</a>
            <a href="returnItem.jsp">Retourner un emprunt</a>
            <a href="ListBorrowings">Emprunts</a>
            <a href="ListBookings">Réservations</a>
        </header>

        <div id="wrap-text">
            <h1>Ajout d'un nouvel Item</h1>
            <p>
                <a href="ListMember">Acc&eacute;der &agrave; la liste des adh&eacute;rent</a>
            </p>


            ${requestScope.alert}
            ${requestScope.confirmationCreationItem}

            <form id="createItemForm" action="CreateItem" method="POST">
                <select name="ouvrage" size="4">
                    <c:forEach var="ouvrage" begin="0" items="${requestScope.ouvrages}">
                        <option value="${ouvrage.id}">${ouvrage.titre}</option>
                    </c:forEach>
                </select>
                <a href="createWork.jsp">+ Ajouter un ouvrage</a><br/>

                <input type="number" name="nbExemplaire" value="1"/>
                <input type="submit"   id="CreateItem"   value="Valider" />      <br/>
            </form>
        </div>
    </body>
</html>
