<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Les ouvrages de la Médiathèque</title>
        <link rel="stylesheet" href="./css/defaultstyle.css" type="text/css" />
    </head>
    <body>
        <header>
            <a href="index.jsp">Accueil</a>
            <a href="ListMember">Adh&eacute;rents</a>
            <a href="listWorks.jsp" id="current-page">Ouvrages</a>
            <!--<a href=".jsp"></a>-->
        </header>

        <div id="wrap-text">
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
        </div>
    </body>
</html>