<%-- 
    Document   : OnlineRents
    Created on : 09-may-2018, 19:29:45
    Author     : alejandrohd
--%>

<%@page import="entities.OnlineRent"%>
<%@page import="java.util.List"%>
<%@page import="ejb.OnlineRentFacade"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alquileres online</title>
    </head>
    <body>
        <%
            OnlineRentFacade onlineRents = (OnlineRentFacade) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/OnlineRentFacade!ejb.OnlineRentFacade");
        %>
        <jsp:include page="/ComercialWebPages/headerComercial.jsp"/>
        <h3 class="text-center">Reservas Online</h3>

        <table class="table text-center">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nombre y apellidos</th>
                    <th scope="col">DNI</th>
                    <th scope="col">Teléfono</th>
                    <th scope="col">Inicio</th>
                    <th scope="col">Fin</th>
                    <th scope="col">Lugar</th>
                    <th scope="col">Coche</th>
                    <th scope="col">Precio</th>
                </tr>
            </thead>
            <%
                List<OnlineRent> onlineList = onlineRents.findAll();

                for (OnlineRent oR : onlineList) {%>
            <tr>
                <th scope="row">-</th>
                <td><%=oR.getNameClient()+" "+oR.getSurnameClient()%></td>
                <td><%=oR.getDniClient() %></td>
                <td><%=oR.getPhoneNumber() %></td>
                <td><%=oR.getDateStart() %></td>
                <td><%=oR.getDateFinish() %></td>
                <td><%=oR.getReservationCity() %></td>
                <td><%=oR.getCarReservation() %></td>
                <td><%=oR.getPriceReservation()+" €" %></td>

            </tr>

            <%}
            %>
        </table>

        <jsp:include page="footer.jsp"/>
    </body>
</html>
