<%-- 
    Document   : createMember
    Created on : 7 nov. 2012, 10:23:59
    Author     : guyader
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajout d'un nouvel Adh&eacute;rent</title>
        <link rel="stylesheet" href="./css/defaultstyle.css" type="text/css" />
    </head>
    <body>
        <header>
            <a href="librarianAccess.jsp">Accueil</a>
            <a href="ListMember" id="current-page">Adh&eacute;rents</a>
            <a href="ListWorks">Ouvrages</a>
            <a href="ListGenres">Genres</a>
            <a href="ListAuthors">Auteurs</a>
            <a href="ListItems">Items</a>
            <a href="borrowItem.jsp">Enregistrer un emprunt</a>
            <a href="returnItem.jsp">Retourner un emprunt</a>
            <a href="ListBorrowings">Emprunts</a>
            <a href="ListBookings">Réservations</a>
        </header>

        <div id="wrap-text">
            <h1>Ajout d'un nouvel Adh&eacute;rent</h1>
            <p>
                <a href="ListMember">Acc&eacute;der &agrave; la liste des adh&eacute;rent</a>
            </p>

            ${requestScope.alert}
            ${requestScope.confirmationCreationMembre}
            <form id="createMemberForm" action="CreateMember" method="POST">
                <label for="prenom">Pr&eacute;nom</label>
                <input type="text"     id="prenom"         name="prenom"        value="${requestScope.prenom}" />        <br/>

                <label for="nom">Nom</label>
                <input type="text"     id="nom"            name="nom"           value="${requestScope.nom}" />           <br/>

                <label for="date_naissance">Date de naissance (<i>format : jj-mm-yyyy</i>)</label>
                <input type="date"     id="date_naissance" name="dateNaissance" value="${requestScope.dateNaissance}" /> <br/>

                <label for="rue_adresse">Adresse : rue</label>
                <input type="text"     id="rue_adresse"    name="rueAdresse"    value="${requestScope.rue}" />          <br/>

                <label for="ville">Ville</label>
                <input type="text"     id="ville"          name="ville"         value="${requestScope.ville}" />        <br/>

                <label for="code_postal">Code postal</label>
                <input type="text"     id="code_postal"    name="codePostal"    value="${requestScope.codePostal}" />   <br/>

                <input type="submit"   id="CreateRecord"   value="Valider" />      <br/>
            </form>
        </div>
    </body>
</html>
