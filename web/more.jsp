<%-- 
    Document   : more
    Created on : 10 nov. 2012, 16:53:58
    Author     : guyader
--%>

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
    </head>
    <body>
        <h1>Plus d'infos sur ${ouvrage.titre}</h1>
        <table>
            <thead>
                <tr>
                    <th>Titre</th>
                    <th>Date 1ère publication</th>
                    <th>Auteurs</th>
                    <th>Genres</th>
                    <th></th>
                </tr>
            </thead>
        </table>
    </body>
</html>
