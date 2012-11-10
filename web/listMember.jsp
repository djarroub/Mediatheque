<%-- 
    Document   : listMember
    Created on : 10 nov. 2012, 21:33:58
    Author     : Gilles
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des adh&eacute;rents</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <th>Nom</th>
                <th>Pr&eacute;nom</th>
                <th>Date de naissance</th>
                <th>Adresse</th>
                <th>Date Adh&eacute;sion</th>
                <th>Date de fin de cotisation</th>
                <th>Solde</th>
            </tr>
            <c:forEach var="adherent" begin="0" items="${requestScope.adherents}">
                <tr>
                    <td>${adherent.nom}</td>
                    <td>${adherent.prenom}</td>
                    <td>${adherent.dateNaissance}</td>
                    <td>
                        ${adherent.adresse.rue}<br/>
                        ${adherent.adresse.ville.nomVille} - 
                        ${adherent.adresse.ville.codePostal}
                    </td>
                    <td>${adherent.dateAdhesion}</td>
                    <td>${adherent.dateFinCotisation}</td>
                    <td>${adherent.soldeCompte}</td>
                </tr>
            </c:forEach>    


        </table>
        <a href="createMember.jsp">Ajouter un nouvel Adh&eacute;rent.</a>
    </body>
</html>
