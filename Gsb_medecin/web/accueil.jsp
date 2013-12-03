<%-- 
    Document   : accueil
    Created on : 5 nov. 2013, 15:13:42
    Author     : ighembaza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="styles.css" />  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                Bienvenue sur GSB Médecin.
            </div>


        </div>
    </body>
</html>
