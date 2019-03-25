<%-- 
    Document   : ViewRents
    Created on : 07-abr-2018, 16:09:56
    Author     : alejandrohd
--%>

<%@page import="entities.CreditPayment"%>
<%@page import="ejb.CreditPaymentFacade"%>
<%@page import="entities.CashPayment"%>
<%@page import="entities.Rent"%>
<%@page import="java.util.List"%>
<%@page import="ejb.CashPaymentFacade"%>
<%@page import="singletonBeans.LogApp"%>
<%@page import="singletonBeans.StatisticsApp"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="statefulBeans.RentDone"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%if (session.getAttribute("usuario") == null) {
        RequestDispatcher req = request.getRequestDispatcher("/PrincipalApp.jsp");
        req.forward(request, response);
    }%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alquileres</title>
    </head>
    <body>
        <jsp:include page="/ComercialWebPages/headerComercial.jsp" />
        <%
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            LogApp logContent = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            estadisticas.addAccess("ViewRents.jsp");
            int valueKey8 = estadisticas.getValue((String) session.getAttribute("usuario"));
            valueKey8++;
            estadisticas.addUserValue((String) session.getAttribute("usuario"), valueKey8);
            logContent.logGenerator("ViewRents::::" + (String) session.getAttribute("usuario"));
            CashPaymentFacade cashPaymentF = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/CashPaymentFacade!ejb.CashPaymentFacade");
            CreditPaymentFacade creditPayment = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/CreditPaymentFacade!ejb.CreditPaymentFacade");
        %>
        <table class="table text-center">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Cliente</th>
                    <th scope="col">DNI</th>
                    <th scope="col">Coche</th>
                    <th scope="col">Días</th>
                    <th scope="col">Precio</th>
                    <th scope="col">Forma de pago</th>
                </tr>
            </thead>
            <%                               
                    List<CashPayment> carsSelect = cashPaymentF.findAll();
                    for (CashPayment c : carsSelect) {

            %>

            <tr>
                <th scope="row">-</th>
                <td><%=c.getIdRentCar().getNameClient() %></td>
                <td><%=c.getIdRentCar().getDniClient() %></td>
                <td><%=c.getIdRentCar().getCarClient() %></td>
                <td><%=c.getIdRentCar().getDays() %></td>
                <td><%=c.getTotalCost()%> €</td>
                <td><%=c.getIdRentCar().getWayToPay()%></td>
            </tr>
            <%}%>
            <%                               
                    List<CreditPayment> carsSelectCredit = creditPayment.findAll();
                    for (CreditPayment credit : carsSelectCredit) {

            %>

            <tr>
                <th scope="row">-</th>
                <td><%=credit.getIdCarRent().getNameClient() %></td>
                <td><%=credit.getIdCarRent().getDniClient() %></td>
                <td><%=credit.getIdCarRent().getCarClient() %></td>
                <td><%=credit.getIdCarRent().getDays() %></td>
                <td><%=credit.getTotalCredit() %> €</td>
                <td><%=credit.getIdCarRent().getWayToPay() %></td>
            </tr>
            <%}%>
        </table>
        <jsp:include page="footer.jsp" />
    </body>
</html>
