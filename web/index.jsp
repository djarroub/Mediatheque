<%-- 
    Document   : index
    Created on : 10 nov. 2012, 10:23:59
    Author     : guyader
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenue sur le catalogue en ligne de la Médiathèque</title>
    </head>
    <body>
        <h1>Bienvenue sur le catalogue en ligne de la Médiathèque</h1>
        <form method="POST" action="/Login">
            <p>
                <label for="login">Numéro de carte</label>
                <input type="text" id="login" name="cardNumber"/><br />
                <label for="password">Mot de passe</label>
                <input type="text" id="password" name="password"/><br />
                <input type="submit" name="connexion" value="connexion"/>
            </p>
        </form>
    </body>
</html>
