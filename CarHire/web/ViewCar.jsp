<%-- 
    Document   : ViewDataCar
    Created on : 15-feb-2018, 19:32:55
    Author     : alejandrohd
--%>

<%@page import="entities.Car"%>
<%@page import="ejb.CarFacade"%>
<%@page import="java.util.List"%>
<%@page import="entities.CarDetails"%>
<%@page import="ejb.CarDetailsFacade"%>
<%@page import="singletonBeans.CarCatalog"%>
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
        <title>Flota</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js" integrity="sha384-feJI7QwhOS+hwpX2zkaeJQjeiwlhOP+SdQDqhgvvo1DsjtiSQByFdThsxO669S2D" crossorigin="anonymous"></script>
    </head>
    <body>
        <%
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            LogApp logContent = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");

            estadisticas.addAccess("ViewCar.jsp");
            int valueKey5 = estadisticas.getValue((String) session.getAttribute("usuario"));
            valueKey5++;
            estadisticas.addUserValue((String) session.getAttribute("usuario"), valueKey5);
            logContent.logGenerator("ViewCar::::" + (String) session.getAttribute("usuario"));
        %>

        <jsp:include page="header.jsp" />

        <h3 class="text-center">Coches de la empresa</h3>
        <div class="container">
            <form action="ViewCar.jsp">
                <div class="input-group">
                    <input id="filtrar" type="text" name="search" class="form-control" placeholder="Buscar por marca">
                    <input type="submit" class="btn btn-light" name="buscar" value="Buscar">
                </div>
            </form>
        </div><br>
        <%
            CarFacade cars = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/CarFacade!ejb.CarFacade");
        %>
        <table class="table text-center">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Marca</th>
                    <th scope="col">Modelo</th>
                    <th scope="col">Tipo</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <%
                if (request.getParameter("search") == null) {
                    List<Car> carsSelect = cars.findAll();
                    for (Car c : carsSelect) {

            %>
            <tr>
                <th scope="row">-</th>
                <td><%=c.getMarcaC()%></td>
                <td><%=c.getModelC()%></td>
                <td><%=c.getTypeC()%></td>
                <td> 
                    <form action="ViewDataCar.jsp">
                        <input type="hidden" name="id" value="<%=c.getIdC()%>">
                        <input type="submit" name="ver" class="btn btn-dark" value="Ver">
                    </form>
                </td>
                <td></td>

            </tr>
            <%}
            } else {

                List<Car> carsSelected = cars.getCarsWithName(request.getParameter("search"));
                for (Car ca : carsSelected) {
            %>
            <tr>
                <th scope="row">-</th>
                <td><%=ca.getMarcaC()%></td>
                <td><%=ca.getModelC()%></td>
                <td><%=ca.getTypeC()%></td>
                <td> 
                    <form action="ViewDataCar.jsp">
                        <input type="hidden" name="id" value="<%=ca.getIdC()%>">
                        <input type="submit" name="ver" class="btn btn-dark" value="Ver">
                    </form>
                </td>
                <td></td>

            </tr>


            <%}
                }%>
        </table>

        <jsp:include page="footer.jsp" />
    </body>
</html>
