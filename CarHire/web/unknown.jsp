<%-- 
    Document   : unknown
    Created on : 16-feb-2018, 20:27:03
    Author     : alejandrohd
--%>

<%@page import="singletonBeans.LogApp"%>
<%@page import="singletonBeans.StatisticsApp"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%if (session.getAttribute("usuario") == null) {
        RequestDispatcher req = request.getRequestDispatcher("/PrincipalApp.jsp");
        req.forward(request, response);
    }%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js" integrity="sha384-feJI7QwhOS+hwpX2zkaeJQjeiwlhOP+SdQDqhgvvo1DsjtiSQByFdThsxO669S2D" crossorigin="anonymous"></script>
    </head>
    <body>
        <%
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            LogApp logContent = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            estadisticas.addAccess("unknown.jsp");
            int valueKey = estadisticas.getValue((String) session.getAttribute("usuario"));
            valueKey++;
            estadisticas.addUserValue((String) session.getAttribute("usuario"), valueKey);
            logContent.logGenerator("unknown::::" + (String) session.getAttribute("usuario"));
        %>
        <%if (session.getAttribute("usuario").equals("Comercial1")) {%>
        <jsp:include page="/ComercialWebPages/headerComercial.jsp"/>
        <%} else {%>
        <jsp:include page="header.jsp" />
        <%}%>
        <h1>¡Comando desconocido!</h1>
        <jsp:include page="footer.jsp" />
    </body>
</html>
