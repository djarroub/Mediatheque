<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenue sur le catalogue en ligne de la Médiathèque</title>
        <link rel="stylesheet" href="./css/defaultstyle.css" type="text/css" />
    </head>
    <body>
        <header>
            <a href="index.jsp">Accueil</a>
            <a href="BrowseCatalog" id="current-page">Catalogue</a>
            <a href="ShowBasket">Panier</a>
        </header>

        <div id="wrap-text">
            <h1>Bienvenue sur le catalogue en ligne de la Médiathèque</h1>
            <table>
                <thead>
                    <tr class="title">
                        <th scope="col">Type</th>
                        <th scope="col">Titre</th>
                        <th scope="col">Date 1ère publication</th>
                        <th scope="col">Auteurs</th>
                        <th scope="col">Genres</th>
                        <th scope="col">Plus d'infos</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="ouvrage" begin="0" items="${requestScope.ouvrages}">
                        <tr class="content">
                            <td>${ouvrage.type.getNom()}</td>
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
                            <td><a href="More?idOuvrage=${ouvrage.id}">Plus d'infos</a></td>
                            <td><a href="AddBasket?idOuvrage=${ouvrage.id}">Ajouter au panier</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
