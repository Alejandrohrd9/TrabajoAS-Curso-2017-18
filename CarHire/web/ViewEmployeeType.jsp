<%-- 
    Document   : ViewEmployeeComercial
    Created on : 04-may-2018, 19:45:49
    Author     : alejandrohd
--%>

<%@page import="ejb.UsersFacade"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="entities.Users"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <h2 align="center">Comerciales</h2>
        <%
            UsersFacade users = (UsersFacade) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/UsersFacade!ejb.UsersFacade");
        if(request.getParameter("search") == null){
            response.sendRedirect("/CarHire/ViewEmployee.jsp");
        }else{
        %>
        
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

            <%
                List<Users> userList = users.getAllUserType(request.getParameter("search"));
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
                        <input type="hidden" name="username" value="<%=u.getUsernameUser()%>">
                        <input type="submit" class="btn btn-dark" value="Editar">
                    </form>
                </td>
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
            %>
        </table>
        <jsp:include page="footer.jsp" />
    </body>
</html>
