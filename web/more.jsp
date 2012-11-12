<%-- 
    Document   : more
    Created on : 10 nov. 2012, 16:53:58
    Author     : guyader
--%>

<%@page import="java.lang.reflect.Field"%>
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
    </head>
    <body>
        <h1>Plus d'infos sur ${ouvrage.titre}</h1>
        <p>
            <%
                for (Field f : ouvrage.getClass().getDeclaredFields()) {
                    out.print(f.get(ouvrage) + "<br/>");
                }
            %>
        </p>
    </body>
</html>
