<%-- 
    Document   : ViewDataCar
    Created on : 20-feb-2018, 19:14:12
    Author     : alejandrohd
--%>

<%@page import="entities.CarDetails"%>
<%@page import="ejb.CarDetailsFacade"%>
<%@page import="singletonBeans.DataCar"%>
<%@page import="singletonBeans.LogApp"%>
<%@page import="singletonBeans.StatisticsApp"%>
<%@page import="statelessBeans.TypeCar"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%if (session.getAttribute("usuario") == null) {
        RequestDispatcher req = request.getRequestDispatcher("/PrincipalApp.jsp");
        req.forward(request, response);
    }%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalles del coche</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js" integrity="sha384-feJI7QwhOS+hwpX2zkaeJQjeiwlhOP+SdQDqhgvvo1DsjtiSQByFdThsxO669S2D" crossorigin="anonymous"></script>
    </head>
    <body>
        <%
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            LogApp logContent = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            estadisticas.addAccess("ViewDataCar.jsp");
            int valueKey6 = estadisticas.getValue((String) session.getAttribute("usuario"));
            valueKey6++;
            estadisticas.addUserValue((String) session.getAttribute("usuario"), valueKey6);
            logContent.logGenerator("ViewDataCar::::" + (String) session.getAttribute("usuario"));
        %>
        <jsp:include page="header.jsp" />
        <h3 class="text-center">Detalles del coche</h3>
        <%
            CarDetailsFacade carsDetail = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/CarDetailsFacade!ejb.CarDetailsFacade"); %>
        <table class="table text-center">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Marca</th>
                    <th scope="col">Modelo</th>
                    <th scope="col">Tipo</th>
                    <th scope="col">Puertas</th>
                    <th scope="col">Matrícula</th>
                    <th scope="col">Precio</th>
                    <th></th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <%    List<CarDetails> carsD = carsDetail.findAll();
                for (CarDetails cD : carsD) {
                    if (cD.getIdCarModel().getIdC() == Integer.parseInt(request.getParameter("id"))) {%>
            <tr>
                <th scope="row">-</th>
                <td><%=cD.getIdCarModel().getMarcaC()%></td>
                <td><%=cD.getIdCarModel().getModelC()%></td>
                <td><%=cD.getIdCarModel().getTypeC()%></td>
                <td><%=cD.getDoorsCar()%></td>
                <td><%=cD.getLicenseCar()%></td>
                <td><%=cD.getPriceCar()%> €</td>
                <td>
                     <form action="EditCar.jsp">
                        <input type="hidden" name="idCarMod" value="<%=cD.getIdCar()%>">
                        <input type="hidden" name="matriMod" value="<%=cD.getLicenseCar() %>">
                        <input type="hidden" name="doorsMod" value="<%=cD.getDoorsCar() %>">
                        <input type="hidden" name="priceMod" value="<%=cD.getPriceCar() %>">
                        <input type="hidden" name="idCarGen" value="<%=request.getParameter("id") %>">
                        <input type="submit" name="edit" class="btn btn-dark" value="Editar">
                    </form>
                </td>
                <td>
                    <form action="FrontServlet">
                        <input type="hidden" name="idCar" value="<%=cD.getIdCar()%>">
                        <input type="hidden" name="command" value="DeleteCarCommand">
                        <input type="submit" name="delete" class="btn btn-dark" value="Eliminar">
                    </form>
                </td>

            </tr>
            <%}
                }%>
        </table>
        <%
        /*if(request.getParameter("delete") != null){
            System.out.println(request.getParameter("idCar"));
            //carsDetail.deleteCar(Integer.parseInt(request.getParameter("idCar")));
           //response.sendRedirect("/CarHire/ViewDataCar.jsp?id="+request.getParameter("idCar"));
           response.sendRedirect("/CarHire/ViewCar.jsp");
        }*/
        %>
        <jsp:include page="footer.jsp" />
    </body>
</html>
