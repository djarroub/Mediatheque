<%-- 
    Document   : createReservation
    Created on : 13 nov. 2012, 21:29:44
    Author     : sbai
--%>

<%@page import="enterprise.ProjetMediatheque.entity.TypeName"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<% TypeName[] types = TypeName.values(); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create an Ouvrage</title>
        <link rel="stylesheet" href="./css/defaultstyle.css" type="text/css" />
    </head>
    <body>
        <header>
            <a href="librarianAccess.jsp">Accueil</a>
            <a href="ListMember">Adh&eacute;rents</a>
            <a href="ListWorks" >Ouvrages</a>
            <a href="ListGenres">Genres</a>
            <a href="ListAuthors">Auteurs</a>
            <a href="ListItems">Items</a>
            <a href="borrowItem.jsp">Enregistrer un emprunt</a>
            <a href="returnItem.jsp">Retourner un emprunt</a>
            <a href="ListBorrowings">Emprunts</a>
            <a href="createReservation.jsp" id="current-page">Réservations</a>
        </header>
        <div id="wrap-text">
            <h1>Ajouter une reservation</h1>
            <form action="CreateReservation" method="POST">
                <table>
                    
                    <tr>
                        <td>Adherent</td>
                        <td>
                            <select name="adherents">
                                <c:forEach var="adherent" begin="0" items="${requestScope.adherentsList}">
                                    <option value="${adherent.numCarte}">${adherent.nom} - ${adherent.prenom}</option>
                                </c:forEach>   
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td>Ouvrage</td>
                        <td>
                            <select name="ouvrages">
                                <c:forEach var="ouvrage" begin="0" items="${requestScope.ouvragesList}">
                                    <option value="${ouvrage.id}">${ouvrage.titre}</option>
                                </c:forEach>   
                            </select>
                        </td>
                    </tr>
                    
                    <tr>
                        <td>Date de Reservation</td>
                        <td>
                          <input type="date" id = "dateDeReservation" name="dateDeReservation" />
                    
                        </td>
                    </tr>
                </table>
                <input type="submit" value="Ajouter" />
            </form>
        </div>
    </body>
</html>
