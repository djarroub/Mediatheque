<%-- 
    Document   : index
    Created on : 10 nov. 2012, 10:23:59
    Author     : guyader
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenue sur le catalogue en ligne de la Médiathèque</title>
        <link rel="stylesheet" href="./css/defaultstyle.css" type="text/css" />
    </head>
    <body>
        <header>
            <a href="index.jsp" id="current-page">Accueil</a>
            <a href="BrowseCatalog">Catalogue</a>
            <a href="ShowBasket">Panier</a>
        </header>

        <div id="wrap-text">
            <h1>Bienvenue sur le catalogue en ligne de la Médiathèque</h1>
            <form method="POST" action="Login">
                <p>
                    <label for="login">Numéro de carte</label>
                    <input type="text" id="login" name="cardNumber"/><br />
                    <label for="password">Mot de passe</label>
                    <input type="text" id="password" name="password"/><br />
                    <input type="submit" name="connexion" value="connexion"/>
                </p>
            </form>
        </div>
    </body>
</html>
