<%-- 
    Document   : ListRechercheOuvrageTitre
    Created on : 13 nov. 2012, 18:11:23
    Author     : sbai
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Résultats de la recherche des ouvrages par titre</title>
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <link rel="stylesheet" href="./css/defaultstyle.css" type="text/css" />
    </head>
    <body>
        <h1>Résultats de la recherche des Ouvrages </h1>
        <table id="ouvrageListTable" border="3">
<tr >
    
    <th bgcolor=>Titre</th>
    <th bgcolor=>Auteur</th>
    <th bgcolor=>Date Première Publication</th>
    <th bgcolor=>Type</th>
   
</tr> 
        <c:forEach var="ouvrage" begin="0" items="${requestScope.ouvrageList}">
        <tr>
           <td>${ouvrage.titre}&nbsp;&nbsp;</td>
           <td>${ouvrage.auteur}&nbsp;&nbsp;</td> 
           <td>${ouvrage.datePremierePublication}&nbsp;&nbsp;</td> 
           <td>${ouvrage.type}&nbsp;&nbsp;</td> 
           
        </tr> 

        </c:forEach>
        </table>
        </body>
</html>
