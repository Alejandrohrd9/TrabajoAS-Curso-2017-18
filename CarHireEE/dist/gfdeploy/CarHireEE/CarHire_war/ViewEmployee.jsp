<%-- 
    Document   : ViewEmployee
    Created on : 23-feb-2018, 16:40:04
    Author     : alejandrohd
--%>


<%@page import="entities.Users"%>
<%@page import="java.util.List"%>
<%@page import="ejb.UsersFacade"%>
<%@page import="singletonBeans.LogApp"%>
<%@page import="singletonBeans.StatisticsApp"%>
<%@page import="model.EmployeeCarHire"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="statelessBeans.EmployeeBean"%>
<%@page contentType="text/html"%>
<%if (session.getAttribute("usuario") == null) {
        RequestDispatcher req = request.getRequestDispatcher("/PrincipalApp.jsp");
        req.forward(request, response);
    }%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type">
        <title>Empleados</title>
    </head>
    <body>
        <%
            /*StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            LogApp logContent = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            estadisticas.addAccess("ViewEmployee.jsp");
            int valueKey7 = estadisticas.getValue((String) session.getAttribute("usuario"));
            valueKey7++;
            estadisticas.addUserValue((String) session.getAttribute("usuario"), valueKey7);
            logContent.logGenerator("ViewEmployee::::" + (String) session.getAttribute("usuario"));*/

        %>
        <jsp:include page="header.jsp" />
        <h2 align="center">Empleados</h2><br>

        <div class="container">
            <form action="ViewEmployeeType.jsp">
                <div class="input-group">
                    <input id="filtrar" type="text" name="search" class="form-control" placeholder="Tipo de usuario que deseas buscar">
                    <input type="submit" class="btn btn-light" value="Buscar">
                </div>
            </form>
        </div><br>

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="mx-auto order-0">
                <div class="btn-group" role="group">
                    <form action="ViewEmployeeOrder.jsp">
                        <input type="submit" class="btn btn-light mx-auto" name="asc" value="A-Z">
                        <!--<a href="ViewEmployeeOrder.jsp" type="button" class="btn btn-primary">Ordenar</a>-->
                    </form>
                    <form action="ViewEmployeeOrder.jsp">
                        <input type="submit" class="btn btn-light mx-auto" name="desc" value="Z-A">
                        <!--<a href="ViewEmployeeOrder.jsp" type="button" class="btn btn-primary">Ordenar</a>-->
                    </form>
                </div>
            </div>
        </nav>
        <%        %>
        <table class="table text-center">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellidos</th>
                    <th scope="col">Usuario</th>
                    <th scope="col">Puesto</th>
                    <th scope="col"></th>
                    <th scope="col"></th>

                </tr>
            </thead>

            <%//for (EmployeeCarHire employee : employeeBean.getEmployeeList(((String) session.getAttribute("usuario")))) {
                    UsersFacade users = (UsersFacade) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/UsersFacade!ejb.UsersFacade");
                    List<Users> userList = users.findAll();
                    userList = users.findAll();
                    for (Users u : userList) {

            %>
            <tr>
                <th scope="row">-</th>
                <td><%= u.getNameUser()%></td>
                <td><%= u.getSurnameUser()%></td>
                <td><%= u.getUsernameUser()%></td>
                <td><%= u.getTypeUser()%></td>
                <td>
                    <form action="UpdateUser.jsp">
                        <input type="hidden" name="username" value="<%=u.getIdUser()%>">
                        <input type="submit" class="btn btn-dark" value="Editar">
                    </form>
                </td>
                <td>  
                    <%if (!session.getAttribute("usuario").equals(u.getUsernameUser())) {
                    %>
                    <form action="FrontServlet">
                        <input type="hidden" name="username" value="<%=u.getUsernameUser()%>" readonly>
                        <input type="hidden" name="command" value="DeleteUserCommand">
                        <input type="submit" class="btn btn-dark" value="Eliminar">
                    </form>
                    <%}%>
                </td>
            </tr>    
            <% }
            %>
        </table>
        <jsp:include page="footer.jsp" />
    </body>
</html>
