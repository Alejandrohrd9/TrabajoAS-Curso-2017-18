<%-- 
    Document   : Logout
    Created on : 19-feb-2018, 22:35:16
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
    </head>
    <body>
        <%
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            LogApp logContent = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            estadisticas.addAccess("Logout.jsp");
            int valueKey1 = estadisticas.getValue((String) session.getAttribute("usuario"));
            valueKey1++;
            estadisticas.addUserValue((String) session.getAttribute("usuario"), valueKey1);
            logContent.logGenerator("Logout::::"+(String) session.getAttribute("usuario"));
        %>
        
        <%session.invalidate();%>
        <jsp:forward page="PrincipalApp.jsp" />
    </body>
</html>
