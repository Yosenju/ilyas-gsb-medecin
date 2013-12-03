<%-- 
    Document   : liste_nom
    Created on : 5 nov. 2013, 15:30:51
    Author     : plasalmonie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="styles.css" />  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des médecins par nom</title>
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
        <h2>Liste des Médecins par nom</h2>
        Veuillez taper le nom ou un bout du nom d'un médecin :
        <form action="Control?choix=nom" method="POST">
            <input type="text" name="choixNom"size="5">
            <input type="submit" value="Envoyer">
        </form>
            </div>


        </div>
    </body>
</html>
