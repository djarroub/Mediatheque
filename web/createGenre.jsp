<%-- 
    Document   : CreateGenre
    Created on : 10 nov. 2012, 15:00:50
    Author     : sbai
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajouter un nouveau Genre</title>
    </head>
    <body>
        <h1>Ajouter un nouveau Genre</h1>
        <form action="CreateGenre" method=""POST">
            <p>
                <label for="nomGenre">Nom du Genre</label><input type="text" id = "nomGenre" name="nomGenre" />
                <input type="submit" value="Ajouter" />
            </p>
        </form>
        <a href="ListGenres">Acc&eacute;der &agrave; la liste des Genres</a>
    </body>
</html>