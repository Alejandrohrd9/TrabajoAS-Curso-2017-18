<%-- 
    Document   : ViewLog
    Created on : 01-abr-2018, 23:24:47
    Author     : alejandrohd
--%>

<%@page import="singletonBeans.StatisticsApp"%>
<%@page import="singletonBeans.LogApp"%>
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
        <title>Log</title>
    </head>
    <body>
        <%
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("ViewLog.jsp");
            int valueKey8 = estadisticas.getValue((String) session.getAttribute("usuario"));
            valueKey8++;
            estadisticas.addUserValue((String) session.getAttribute("usuario"), valueKey8);
            LogApp logContent = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            String log = logContent.getLog();

        %>
        <%if (session.getAttribute("usuario").equals("Comercial1")) {%>
        <jsp:include page="/ComercialWebPages/headerComercial.jsp"/>
        <%} else {%>
        <jsp:include page="header.jsp" />
        <%}%>
        <pre class="text-center"><%=log%></pre>
        <jsp:include page="footer.jsp" />
    </body>
</html>
