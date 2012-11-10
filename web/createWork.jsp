<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create an Ouvrage</title>
    </head>
    <body>

    <h1>Create a Person record</h1>
    <form id="createOuvrageForm" action="CreateOuvrage" method="post">
    <table>
        <tr><td>Titre</td><td><input type="text" id = "titre" name="titre" /></td></tr>
        <tr><td>Date Première Publication</td><td><input type="date" id = "datePremierePublication" name="datePremierePublication" /></td></tr>
        <tr><td>Auteurs</td><td>
                <select name="id" id="id" multiple="multiple">
                  <c:forEach var="auteur" begin="0" items="${requestScope.auteursList}">
                      <option value="${auteur.id}">${auteur.nom} - ${auteur.prenom}</option>
                   </c:forEach>   
                </select>
            </td></tr>
        
        <tr><td>Genres</td><td>
                <select name="nomGenre" id="nomGenre" multiple="multiple">
                  <c:forEach var="genre" begin="0" items="${requestScope.auteursList}">
                      <option value="${genre.nomGenre}">${genre.nomGenre} </option>
                   </c:forEach>   
                </select>
            </td></tr>
    
    </table>
    <input type="submit" id="CreateRecord" value="CreateRecord" />
    </form>
<a href="ListOuvrage"><strong>Go to List of Ouvrages</strong></a>
</body>
</html>
