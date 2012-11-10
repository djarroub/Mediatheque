<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Les ouvrages de la Médiathèque</title>
    </head>
    <body>
        <h1>Les ouvrages de la Médiathèque</h1>
        <table>
            <thead>
                <tr>
                    <th>Titre</th>
                    <th>Date 1ère publication</th>
                    <th>Auteurs</th>
                    <th>Genres</th>
                    <th>Plus d'infos</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="ouvrage" begin="0" items="${requestScope.ouvrages}">
                    <tr>
                        <td>${ouvrage.titre}</td>
                        <td>${ouvrage.datePremierePublication}</td>
                        <td>
                            <c:forEach var="auteur" begin="0" items="${ouvrage.auteurs}">
                                ${auteur.prenom} ${auteur.nom}<br/>
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach var="genre" begin="0" items="${ouvrage.genres}">
                                ${genre.nomGenre}<br/>
                            </c:forEach>
                        </td>
                        <td><a href="/More?idOuvrage=${ouvrage.id}"</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>