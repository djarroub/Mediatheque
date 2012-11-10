<%-- 
    Document   : listMember
    Created on : 10 nov. 2012, 21:33:58
    Author     : Gilles
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des adh&eacute;rents</title>
    </head>
    <body>
        <table>
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
                        ${adherent.adherent.rue}<br/>
                        ${adherent.adherent.ville.nomVille} - 
                        ${adherent.adherent.ville.codePostal}
                    </td>
                    <td>${adherent.dateAdhesion}</td>
                    <td>${adherent.dateFinCotisation}</td>
                    <td>${adherent.soldeCompte}</td>
                </tr>
            </c:forEach>    

        </table>
    </body>
</html>
