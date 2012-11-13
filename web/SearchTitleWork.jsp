<%-- 
    Document   : RechercheOuvrageTitre
    Created on : 13 nov. 2012, 18:21:15
    Author     : sbai
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recherche Ouvrage</title>
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <link rel="stylesheet" href="./css/defaultstyle.css" type="text/css" />
    </head>
    <body>
        <h1>Recherche d'un Ouvrage Par Titre</h1>
        
    
        <form id="RechercheForm" action="RechercheTitre" method="post">
            
              Recherche par titre:<input type="text" name="titre" /> <br/>
            
            <input type="submit" id="RechercheTitre" value="Rechercher Titre" />
        </form>
          
       
    </body>
</html>
