<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Les ouvrages de la Médiathèque</title>
        <link rel="stylesheet" href="./css/defaultstyle.css" type="text/css" />
    </head>
    <body>
        <header>
            <a href="librarianAccess.jsp">Accueil</a>
            <a href="ListMember">Adh&eacute;rents</a>
            <a href="ListWorks" id="current-page">Ouvrages</a>
            <a href="ListGenres">Genres</a>
            <a href="ListAuthors">Auteurs</a>
            <a href="ListItems">Items</a>
            <a href="borrowItem.jsp">Enregistrer un emprunt</a>
            <a href="returnItem.jsp">Retourner un emprunt</a>
            <a href="ListBorrowings">Emprunts</a>
            <a href="ListBookings">Réservations</a>
        </header>

        <div id="wrap-text">
            <h1>Les ouvrages de la Médiathèque</h1>
            <p>
                Ajouter :<br/>
                <a href="CreateBook">+ Un Livre.</a>
                <a href="CreateCD">+ Un CD.</a>
                <a href="CreateDVD">+ Un DVD.</a>
                <a href="CreateJournal">+ Une Revue.</a>
                <a href="CreateMagazine">+ Un Magazine.</a>
                <a href="CreateVideotape">+ Une Cassette Video.</a>
            </p>
            <table>
                <thead>
                    <tr class="title">
                        <th scope="col">Type</th>
                        <th scope="col">Titre</th>
                        <th scope="col">Date 1ère publication</th>
                        <th scope="col">Auteurs</th>
                        <th scope="col">Genres</th>
                        <th scope="col">Plus d'infos</th>
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
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>