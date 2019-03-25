<%-- 
    Document   : NewCar
    Created on : 15-feb-2018, 18:02:02
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
        <title>Nuevo coche</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js" integrity="sha384-feJI7QwhOS+hwpX2zkaeJQjeiwlhOP+SdQDqhgvvo1DsjtiSQByFdThsxO669S2D" crossorigin="anonymous"></script>
    </head>
    <body>
        <%
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            LogApp logContent = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            estadisticas.addAccess("NewCar.jsp");
            int valueKey3 = estadisticas.getValue((String) session.getAttribute("usuario"));
            valueKey3++;
            estadisticas.addUserValue((String) session.getAttribute("usuario"), valueKey3);
            logContent.logGenerator("NewCar::::"+(String) session.getAttribute("usuario"));
        %>
        <jsp:include page="header.jsp" />
        <h3>Añadir coche</h3>
        <form action='FrontServlet'>
            <div class ="form-group row">

                <label for="example-search-input" class="col-2 col-form-label">Marca:</label>
                <div class="col-10">
                    <input type='text' name='marcaC'><br>
                </div>
            </div>    

            <div class ="form-group row">
                <label for="example-search-input" class="col-2 col-form-label">Modelo:</label>
                <div class="col-10">
                    <input type='text' name='modeloC'><br>
                </div>
            </div>
            
            <div class ="form-group row">
                <label for="example-search-input" class="col-2 col-form-label">Precio(€)/Día:</label>
                <div class="col-10">
                    <input type='text' name='precioC'><br>
                </div>
            </div>

            <input type='hidden' name='command' value='NewCarCommand'>
            <input type='submit' value='Añadir'>
        </form>
        <jsp:include page="footer.jsp" />
    </body>
</html>
