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
            <h1>Ajouter un Ouvrage</h1>
            <form action="CreateWork" method="POST">
                <table>
                    <tr>
                        <td>Titre</td>
                        <td><input type="text" id = "titre" name="titre" /></td>
                    </tr>
                    <tr>
                        <td>Date Première Publication</td>
                        <td><input type="date" id = "datePremierePublication" name="datePremierePublication" /></td>
                    </tr>
                    <tr>
                        <td>Auteurs</td>
                        <td>
                            <select name="auteurs" multiple="multiple">
                                <c:forEach var="auteur" begin="0" items="${requestScope.auteursList}">
                                    <option value="${auteur.id}">${auteur.nom} - ${auteur.prenom}</option>
                                </c:forEach>   
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td>Genres</td>
                        <td>
                            <select name="genres" multiple="multiple">
                                <c:forEach var="genre" begin="0" items="${requestScope.genresList}">
                                    <option value="${genre.nomGenre}">${genre.nomGenre}</option>
                                </c:forEach>   
                            </select>
                        </td>
                    </tr>
                    
                    <tr>
                        <td>Type</td>
                        <td>
                            <select name="type">
                                <% 
                                    for (int i=0; i<types.length; i++)
                                        out.println("<option value=\""+ types[i] +"\">"+ types[i] +"</option>");
                                %>
                            </select>
                        </td>
                    </tr>
                </table>
                <input type="submit" value="Ajouter" />
            </form>
        </div>
    </body>
</html>
