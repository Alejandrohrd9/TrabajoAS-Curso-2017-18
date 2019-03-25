<%-- 
    Document   : Rents
    Created on : 30-mar-2018, 20:49:45
    Author     : alejandrohd
--%>

<%@page import="singletonBeans.LogApp"%>
<%@page import="statefulBeans.RentDone"%>
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
        <title>Detalles alquiler</title>
    </head>
    <body>
        <%            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            LogApp logContent = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            estadisticas.addAccess("Rents.jsp");
            int valueKeyRents = estadisticas.getValue((String) session.getAttribute("usuario"));
            valueKeyRents++;
            estadisticas.addUserValue((String) session.getAttribute("usuario"), valueKeyRents);
            logContent.logGenerator("Rents::::"+session.getAttribute("usuario"));
            RentDone rentFinished = (RentDone) session.getAttribute("rentFinished");
            if (rentFinished == null) {
                rentFinished = (RentDone) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/RentDone!statefulBeans.RentDone");
            }
        %>
        <jsp:include page="/ComercialWebPages/headerComercial.jsp" />
        <%String hidden = request.getParameter("reserva");
        System.out.println(hidden);
        String dataRent =rentFinished.getValue(hidden, (String) session.getAttribute("usuario"));
        %>
        <pre class="text-center"><%=dataRent%></pre>
         <jsp:include page="footer.jsp" />
    </body>
</html>
