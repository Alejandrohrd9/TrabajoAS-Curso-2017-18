<%-- 
    Document   : ViewEmployeeOrder
    Created on : 04-may-2018, 19:07:53
    Author     : alejandrohd
--%>

<%@page import="entities.Users"%>
<%@page import="java.util.List"%>
<%@page import="ejb.UsersFacade"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <h2 align="center">Empleados</h2>
        <%
            UsersFacade users = (UsersFacade) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/UsersFacade!ejb.UsersFacade");
            if (request.getParameter("asc") != null) {
        %>

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="mx-auto order-0">
                <div class="btn-group" role="group">
                    <form action="ViewEmployee.jsp">
                        <input type="submit" class="btn btn-light mx-auto" value="Natural">
                    </form>
                </div>
            </div>
        </nav>
        <%} else {%>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="mx-auto order-0">
                <div class="btn-group" role="group">
                    <form action="ViewEmployee.jsp">
                        <input type="submit" class="btn btn-light mx-auto" value="Natural">
                    </form>
                </div>
            </div>
        </nav>
        <%}%>
        <table class="table text-center">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellidos</th>
                    <th scope="col">Usuario</th>
                    <th scope="col">Puesto</th>
                    <th scope="col"></th>
                </tr>
            </thead>

            <%//for (EmployeeCarHire employee : employeeBean.getEmployeeList(((String) session.getAttribute("usuario")))) {
                if (request.getParameter("asc") != null) {
                    List<Users> userList = users.getAllUserOrder();
                    for (Users u : userList) {

            %>
            <tr>
                <th scope="row">-</th>
                <td><%= u.getNameUser()%></td>
                <td><%= u.getSurnameUser()%></td>
                <td><%= u.getUsernameUser()%></td>
                <td><%= u.getTypeUser()%></td>
                <td>  
                    <%if (!session.getAttribute("usuario").equals(u.getUsernameUser())) {
                    %>
                    <form action="FrontServlet">
                        <input type="hidden" name="username" value="<%=u.getUsernameUser()%>">
                        <input type="hidden" name="command" value="DeleteUserCommand">
                        <input type="submit" class="btn btn-dark" value="Eliminar">
                    </form>
                    <%}%>
                </td>
            </tr>    

            <% }
                }
                if (request.getParameter("desc") != null) {
                    List<Users> userList = users.getAllUserOrderDesc();
                    for (Users u : userList) {
            %>
            <tr>
                <th scope="row">-</th>
                <td><%= u.getNameUser()%></td>
                <td><%= u.getSurnameUser()%></td>
                <td><%= u.getUsernameUser()%></td>
                <td><%= u.getTypeUser()%></td>
                <td>  
                    <%if (!session.getAttribute("usuario").equals(u.getUsernameUser())) {
                    %>
                    <form action="FrontServlet">
                        <input type="hidden" name="username" value="<%=u.getUsernameUser()%>">
                        <input type="hidden" name="command" value="DeleteUserCommand">
                        <input type="submit" class="btn btn-dark" value="Eliminar">
                    </form>
                    <%}%>
                </td>
            </tr>    

            <%}
                }
            %>
        </table>
        <jsp:include page="footer.jsp" />
    </body>
</html>
