<%-- 
    Document   : liste_departement
    Created on : 5 nov. 2013, 15:30:11
    Author     : plasalmonie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>


        <form action="Control?choix=valider">
            <select name="choixDep">
                <c:forEach var="leDep" items="${departements}">
                <option value="${leDep.num}">${leDep.num}</option>
            </c:forEach>                
            </select>
            <input type="submit" value="Envoyer">
    </form>
</body>
</html>
