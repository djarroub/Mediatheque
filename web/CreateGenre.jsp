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
        <title>Create a Genre Record</title>
    </head>
    <body>

    <h1>Create a Genre record</h1>
    <form id="createGenreForm" action="CreateGenre" method="post">
    <table>
        
        <tr><td>Nom Genre</td><td><input type="text" id = "nomGenre" name="nomGenre" /></td></tr>
        
    </table>
    <input type="submit" id="CreateRecord" value="CreateRecord" />
    </form>
<a href="ListGenre"><strong>Go to List of genres</strong></a>
</body>
</html>
