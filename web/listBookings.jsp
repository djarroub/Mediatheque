<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des genres</title>
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <link rel="stylesheet" href="./css/defaultstyle.css" type="text/css" />
    </head>
    <body>
        <header>
            <a href="librarianAccess.jsp">Accueil</a>
            <a href="ListMember">Adh&eacute;rents</a>
            <a href="ListWorks">Ouvrages</a>
            <a href="ListGenres" id="current-page">Genres</a>
            <a href="ListAuthors">Auteurs</a>
            <a href="ListItems">Items</a>
            <a href="borrowItem.jsp">Enregistrer un emprunt</a>
            <a href="returnItem.jsp">Retourner un emprunt</a>
            <a href="ListBorrowings">Emprunts</a>
            <a href="ListBookings" id="current-page">Réservations</a>
        </header>

        <div id="wrap-text">
            <h1>Liste des Reservations</h1>
            <a href="CreateReservation">+ Ajouter une Reservation.</a>
            <table>
                <thead>
                    <tr class="title">
                        <th scope="col">Date de reservation</th>
                        <th scope="col">Date d'expiration</th>
                        <th scope="col">Nom de l'Adherent</th>
                        <th scope="col">Titre de l'Ouvrage</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="reservation" begin="0" items="${requestScope.reservations}">
                        <tr class="content">
                            <td>${reservation.dateDeReservation}</td>
                            <td>${reservation.dateDExpiration}</td>
                            <td>${reservation.adherent.prenom} ${reservation.adherent.nom}</td>
                            <td>${reservation.ouvrage.titre}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
