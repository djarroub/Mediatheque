<%-- 
    Document   : confirmationCreateMember
    Created on : 10 nov. 2012, 18:15:32
    Author     : Gilles
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation cr&eacute;ation Adh&eacute;rent</title>
    </head>
    <body>
        <p>
            L'adh&eacute;rent(e) ${requestScope.prenom} ${requestScope.nom} a bien &eacute;t&eacute; ajout&eacute;(e).<br/>
            <a href="createMember.jsp">Ajouter un autre membre</a>
        </p>
    </body>
</html>
