<%-- 
    Document   : EditCar
    Created on : 16-feb-2018, 23:11:29
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
        <title>Editar Datos Coche</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js" integrity="sha384-feJI7QwhOS+hwpX2zkaeJQjeiwlhOP+SdQDqhgvvo1DsjtiSQByFdThsxO669S2D" crossorigin="anonymous"></script>
    </head>
    <body>
        <%
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            LogApp logContent = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            estadisticas.addAccess("EditCar.jsp");
            int valueKey2 = estadisticas.getValue((String) session.getAttribute("usuario"));
            valueKey2++;
            estadisticas.addUserValue((String) session.getAttribute("usuario"), valueKey2);
            logContent.logGenerator("EditCar::::" + (String) session.getAttribute("usuario"));
        %>
        <jsp:include page="header.jsp" />
        <h3>Edición de coche</h3>

        <form action="FrontServlet">

            <div class ="form-group row">
                <label for="example-search-input" class="col-2 col-form-label">Matrícula:</label>
                <div class="col-10">
                    <input type="text" name="matricula" value="<%=request.getParameter("matriMod")%>"><br>
                </div>
            </div>

            <div class ="form-group row">
                <label for="example-search-input" class="col-2 col-form-label">Nº de puertas:</label>
                <div class="col-10">
                    <input type="text" name="doors" value="<%=request.getParameter("doorsMod")%>"><br>
                </div>
            </div>

            <div class ="form-group row">
                <label for="example-search-input" class="col-2 col-form-label">Precio:</label>
                <div class="col-10">
                    <input type="text" name="price" value="<%=request.getParameter("priceMod")%>"><br>
                </div>
            </div>

            <input type="hidden" name="idGenUp" value="<%=request.getParameter("idCarGen")%>">    
            <input type="hidden" name="idCarUp" value="<%=request.getParameter("idCarMod")%>">       
            <input type="hidden" name="command" value="EditCarCommand">
            <input type="submit" value="Guardar">
        </form>

    </body>
</html>
