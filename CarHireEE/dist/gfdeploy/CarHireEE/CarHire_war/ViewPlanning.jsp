<%-- 
    Document   : ViewPlanning
    Created on : 25-feb-2018, 18:40:54
    Author     : alejandrohd
--%>

<%@page import="java.util.List"%>
<%@page import="entities.Planning"%>
<%@page import="ejb.PlanningFacade"%>
<%@page import="ejb.UsersFacade"%>
<%@page import="singletonBeans.LogApp"%>
<%@page import="singletonBeans.StatisticsApp"%>
<%@page import="model.DayWeek"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="statelessBeans.PlanningWeek"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%if (session.getAttribute("usuario") == null) {
        RequestDispatcher req = request.getRequestDispatcher("/PrincipalApp.jsp");
        req.forward(request, response);
    }%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Planning</title>
    </head>
    <body>
        <%
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            LogApp logContent = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            estadisticas.addAccess("ViewPlanning.jsp");
            int valueKey8 = estadisticas.getValue((String) session.getAttribute("usuario"));
            valueKey8++;
            estadisticas.addUserValue((String) session.getAttribute("usuario"), valueKey8);
            logContent.logGenerator("ViewPlanning::::"+(String) session.getAttribute("usuario"));

            UsersFacade users = (UsersFacade) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/UsersFacade!ejb.UsersFacade");
        %>
        <%if (users.getTypeUser((String) session.getAttribute("usuario"), (String) session.getAttribute("password")).equals("Comercial")) {%>
        <jsp:include page="/ComercialWebPages/headerComercial.jsp"/>
        <%} else {%>
        <jsp:include page="header.jsp" />
        <%}%>

        <%
            //PlanningWeek planningWeek = (PlanningWeek) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/PlanningWeek!statelessBeans.PlanningWeek");
            PlanningFacade planningWeek = (PlanningFacade) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/PlanningFacade!ejb.PlanningFacade");
        %>
        <h2 align="center">Planning semanal</h2>
        <table class="table text-center">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Día</th>
                    <th scope="col">Lunes</th>
                    <th scope="col">Martes</th>
                    <th scope="col">Miércoles</th>
                    <th scope="col">Jueves</th>
                    <th scope="col">Viernes</th>
                    <th scope="col">Sábado</th>
                    <th scope="col">Domingo</th>
                </tr>
            </thead>

            <%
                //for (DayWeek employee : planningWeek.getListDays((String) session.getAttribute("usuario"))) {
                List <Planning> planning = planningWeek.findAll();
                for (Planning p : planning) {
                        
            %>
            <tr>
                <th scope="row"><%=p.getHora()%></th>
                <td><%=p.getLunes() %></td>
                <td><%=p.getMartes() %></td>
                <td><%=p.getMiercoles() %></td>
                <td><%=p.getJueves() %></td>
                <td><%=p.getViernes() %></td>
                <td><%=p.getSabado() %></td>
                <td><%=p.getDomingo() %></td>
            </tr>    
            <% }%>
        </table>


        <jsp:include page="footer.jsp" />
    </body>
</html>
