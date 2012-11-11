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
    </head>
    <body>
        <table border="1">
            <tr>
                <th>Nom</th>
                <th>Pr&eacute;nom</th>
                <th>Date de naissance</th>
                <th>Adresse</th>
                <th>Date Adh&eacute;sion</th>
                <th>Date de fin de cotisation</th>
                <th>Solde</th>
            </tr>
            <c:forEach var="adherent" begin="0" items="${requestScope.adherents}">
                <tr class="toto">
                    <td>${adherent.nom}</td>
                    <td>${adherent.prenom}</td>
                    <td class="dateNaiss">${adherent.dateNaissance}</td>
                    <td>
                        ${adherent.adresse.rue}<br/>
                        ${adherent.adresse.ville.nomVille} - 
                        ${adherent.adresse.ville.codePostal}
                    </td>
                    <td>${adherent.dateAdhesion}</td>
                    <td>${adherent.dateFinCotisation}</td>
                    <td>${adherent.soldeCompte}</td>
                </tr>
            </c:forEach>    


        </table>
        <a href="createMember.jsp">Ajouter un nouvel Adh&eacute;rent.</a>

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
                    alert("res = " + res);
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
                var nbOccurrence = $('.dateNaiss').length;
                for(var i=0; i<nbOccurrence; i++){
                    var oldDate = $(".dateNaiss").eq(i).text();
                    var newDate = dateJavaToFr(oldDate);
                    $(".dateNaiss").eq(i).text(newDate);
                }
            });
        </script>
    </body>
</html>
