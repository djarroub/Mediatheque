<%-- 
    Document   : listMember
    Created on : 10 nov. 2012, 21:33:58
    Author     : Gilles
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des adh&eacute;rents</title>
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <link rel="stylesheet" type="text/css" href="css/defaultstyle.css">
    </head>
    <body>
        <header>
            <a href="index.jsp">Accueil</a>
            <a href="ListMember" id="current-page">Adh&eacute;rents</a>
            <a href="listWorks.jsp">Ouvrages</a>
            <!--<a href=".jsp"></a>-->
        </header>
        
        <div id="wrap-text">
            <h1>Liste des Adh&eacute;rents</h1>
            <a href="createMember.jsp">+ Ajouter un nouvel Adh&eacute;rent.</a>
            <table>
                <thead>
                    <tr class="title">
                        <th scope="col">Pr&eacute;nom</th>
                        <th scope="col">Nom</th>
                        <th scope="col">Date de naissance</th>
                        <th scope="col">Adresse</th>
                        <th scope="col">Date Adh&eacute;sion</th>
                        <th scope="col">Date de fin de cotisation</th>
                        <th scope="col">Solde</th>
                        <th scope="col">Editer</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="adherent" begin="0" items="${requestScope.adherents}">
                        <tr class="content">
                            <td>${adherent.prenom}</td>
                            <td>${adherent.nom}</td>
                            <td class="dateAParser">${adherent.dateNaissance}</td>
                            <td>
                                ${adherent.adresse.rue}<br/>
                                ${adherent.adresse.ville.nomVille} - 
                                ${adherent.adresse.ville.codePostal}
                            </td>
                            <td class="dateAParser">${adherent.dateAdhesion}</td>
                            <td class="dateAParser">${adherent.dateFinCotisation}</td>
                            <td>${adherent.soldeCompte}</td>
                            <td><a href="#"><img width="34" height="34" title="" alt="" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACIAAAAiCAIAAAC1JZyVAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAIGNIUk0AAHolAACAgwAA+f8AAIDpAAB1MAAA6mAAADqYAAAXb5JfxUYAAAQsSURBVHjarJdLc1tFEIVPz4wedqzHlR0/FBNYkgpFQbHgF/BXSVYsw4oqFuwI2FBQEKhKOQEnhMRWHDt+SNN9WMzMlRxCcGxrId2Z29Pfvd2ne0Zixp0t3f4p7v5hOoHzhCB/iNkPZ4csN1+xmf5Io4XFd/3wph9c9+HZlm58MX78azRloyW+BeeLIxbvPDWkZQyNmUfQQGZjGkQgHk9+173H4cZnCNs/xke/xMOR9dZcd9m1OhIaUtyRZb0paKCRBhpMs0GaL980Aw1UmBLA5Jj7z2zvsYXRtpmyt+bW3g/VumstiA/5kU8tLu5MSYNFWLqlsAhTUKkKU6hGRm8RpiThmzg5YNCIZlu6y65ad/2ha8yJSHn87FRME5IaYVFqsEaxSItQTUOMZXTc32g//UheVhahEaEpgDjn6Ftod6XdkcachKb4hjgPH+AbcEHEw3k4D3Hi8rU4AQTOQZyIgxNAJDZGJyuby8P+2qc7vrMPQCTpgSFZ+yDOp9mSkpyPkgzLmUhxSznQmOOmirGMjhZ/WFyqhsPhwsJCt7d/7w5tt2MKAA5AUnBxnV1YcUFNMUkRK/lQ6ASmTJEZy+hwcXNxqT8cDquqmp+fX1oeDD8Za8zGodZuynBOzAUYjUYDwMHf/sFXVVpFQyiM7JSuhOUCjNGfdvcWx4diydIY6gpP2oVIjbwYA5kRBYYwy6BJKotLYdSJMZvJjRlM4QDaGRkbSVdvYsRczhlTihEAzM7KuHbtWr/frxnffs7J0SmGRpoKDYFFZqllGaRU+/8zqqoKIbyJkfxMJWA0hUY4P33Zy2Eo+IoELEoK4NkZuw/t7u3XM0qPKLkpEUvdWy6TkcqTCGnLyoEygEySO8Vwu0eDzbdl6KTeIxDy3kjk3i6gvY5xdZC0+5YMpl0n5JZsNKVGcW76vm9i3OLk+CyM1N05EzSFRdLJZTE05losEkDp/BHisrIneHE42Kzr/HyMdOtUF0i7kzOowpRH7e2Fzvzq6mrN2Hlg391+OwYVZtPcpOMIqVARU2okWwe9Xq/b7V6EoaU8XSpPU2qajdRo+wvft6qTTqeT+tWz+xdgpNzUak6LIbbf2WhdfbmyMuwu9O9/454/iqMt0XgeRhYb643AkI5CsbknvdHKyjtXl1bvfdne3ZKkiHMzTMkk6HJOxNiOjqqN5arqzS//dmdu9DDl6byMmA+nIAIgInmWxvbzGzE2f/66lxrBBRmmpIqZhEYL8FkFOJnDydzBU1wWIx3RQhNusO7ney40hSx2ccqoT8kz+8fMhf5XPkADgEZbrlQyWPdh+KHfe+IPduib6byb7KR4lLJY7N8Bsbq1s97mU6+ECQVXKrn+cRh+4MWMuw/1xV92fEBAIET5m2FG5GNtHuZCJqipDGZmphcEQRPfxGDdr930S+/5fwYAn1bf5LV45TkAAAAASUVORK5CYII=" /></a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        
            
        
        
        <script>
            /*
             * Affiche la date sous la forme "dd/mm/yyyy"
             * @param Une date sous la forme "Wed Nov 30 00:00:00 CET 1988"
             */
            function dateJavaToFr(date){
                // parse le texte avec les espaces
                var tabDate = date.split(" ");
                if(tabDate.length == 6){
                    var j = tabDate[2];
                    var m = moisToInt(tabDate[1]);
                    var a = tabDate[5];
                    var res = "" + j + "/" + m + "/" + a;
                    return res;
                }else{
                    return "error";
                }
            }
            
            /*
             * Retourne le numero du mois en fonction du nom du mois.
             * @param Le nom du mois en anglais, et sur 3 caracteres (exp : "Apr" pour le mois d'avril).
             * @return Un int.
             */
            function moisToInt(mois){
                var tabMois = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Agu", "Sep", "Oct", "Nov", "Dec"];
                for(var i=0; i<12; i++){
                    if(tabMois[i] == mois){
                        return i+1;
                    }
                }
                return "-1";
            }

            $(document).ready(function() {
                // remplace toutes les dates de naissance par une date au format "dd/mm/yyyy"
                var nbOccurrence = $('.dateAParser').length;
                for(var i=0; i<nbOccurrence; i++){
                    var oldDate = $(".dateAParser").eq(i).text();
                    var newDate = dateJavaToFr(oldDate);
                    $(".dateAParser").eq(i).text(newDate);
                }
            });
        </script>
    </body>
</html>
