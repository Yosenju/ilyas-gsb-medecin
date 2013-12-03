<%-- 
    Document   : listemedecin
    Created on : 5 nov. 2013, 12:53:21
    Author     : ighembaza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="styles.css" />  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des médecins</title>
    </head>
    <body>
        <div id="page">
            <div id="entete">
                <img id="logoGSB" src="logo.jpg">
                <h1 id="entete h1">Galaxy Swiss Bourdin</h1>
            </div>
            <div id="menuGauche">
                <ul id="menuList">
                    <li><a href = "accueil.jsp">Accueil</a></li><br/>
                    
                    <li><a href = "control?choix=dep">Liste des médecins par département</a></li>

                    <li><a href = "control?choix=nom">Liste des médecins par nom</a></li>
                    
                    <li><a href = "control?choix=spe">Liste des médecins par spécialité complémentaire</a></li>
                </ul>
            </div>
            <div id="contenu">
        <h2>Liste des Médecins</h2>
        <table>
            <tr>
            <td>Nom</td>
            <td>Prénom</td>
            <td>Adresse</td>
            <td>Téléphone</td>
            <td>Spécialité</td>
        </tr>

        <c:forEach var="med" items="${listemedecin}">
            <tr>
                <td>${med.nom}</td>
                <td>${med.prenom}</td>
                <td>${med.adresse}</td>
                <td>${med.tel}</td>
                <td>${med.spe}</td>
            </tr>
 
    </c:forEach>
</table>
        </div>
    </body>
</html>