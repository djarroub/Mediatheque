<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="enterprise.ProjetMediatheque.entity.Ouvrage"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! Ouvrage ouvrage; %>
<% ouvrage = (Ouvrage) request.getAttribute("ouvrage"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Plus d'infos sur ${ouvrage.titre}</title>
        <link rel="stylesheet" href="./css/defaultstyle.css" type="text/css" />
    </head>
    <body>
        <header>
            <a href="index.jsp">Accueil</a>
            <a href="BrowseCatalog" id="current-page">Catalogue</a>
            <a href="showBasket.jsp">Panier</a>
        </header>
    
        <div id="wrap-text">
            <h1>Plus d'infos sur ${ouvrage.titre}</h1>
            <p>
                ${ouvrage.toString()}
            </p>
        </div>
    </body>
</html>
