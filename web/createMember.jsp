<%-- 
    Document   : createMember
    Created on : 7 nov. 2012, 10:23:59
    Author     : guyader
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajout d'un nouvel Adh&eacute;rent</title>
        <link rel="stylesheet" href="./css/defaultstyle.css" type="text/css" />
    </head>
    <body>
        <header>
            <a href="index.jsp">Accueil</a>
            <a href="ListMember" id="current-page">Adh&eacute;rents</a>
            <a href="listWorks.jsp">Ouvrages</a>
            <!--<a href=".jsp"></a>-->
        </header>

        <div id="wrap-text">
            <h1>Ajout d'un nouvel Adh&eacute;rent</h1>
            <p>
                <a href="ListMember">Acc&eacute;der &agrave; la liste des adh&eacute;rent</a>
            </p>


            ${requestScope.alert}
            <form id="createMemberForm" action="CreateMember" method="post">
                <label for="prenom">Pr&eacute;nom</label>
                <input type="text"      id="prenom"         name="prenom"/>         <br/>

                <label for="nom">Nom</label>
                <input type="text"      id="nom"            name="nom" />           <br/>

                <label for="date_naissance">Date de naissance</label>
                <input type="date"      id="date_naissance" name="dateNaissance" /> <br/>

                <label for="mdp">Mot de passe</label>
                <input type="password"  id="mdp"            name="motDePasse" />    <br/>

                <label for="mdp_bis">R&eacute;p&eacute;ter le mot de passe</label>
                <input type="password"  id="mdp_bis"            name="motDePasseBis" /> <br/>

                Adresse :
                <label for="rue_adresse">Rue</label>
                <input type="text"      id="rue_adresse"    name="rueAdresse" />    <br/>

                <label for="ville">Ville</label>
                <input type="text"      id="ville"          name="ville" />         <br/>

                <label for="code_postal">Code postal</label>
                <input type="text"      id="code_postal"    name="codePostal" />    <br/>

                <input type="submit"    id="CreateRecord"   value="Valider" />      <br/>
            </form>
        </div>
    </body>
</html>
