<%-- 
    Document   : UpdateUser
    Created on : 05-may-2018, 13:13:47
    Author     : alejandrohd
--%>

<%@page import="entities.Users"%>
<%@page import="java.util.List"%>
<%@page import="ejb.UsersFacade"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            UsersFacade users = (UsersFacade) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/UsersFacade!ejb.UsersFacade");

        %>
        <jsp:include page="header.jsp" />
        <h3 class="text-center title">Edición de empleado</h3>
        <div class="container py-5">
            <div class="row">
                <div class="col-md-12">
                    <div class="row">
                        <div class="col-md-8 mx-auto">
                            <div class="card rounded-0">
                                <div class="card-body">
                                    <%                                        List<Users> userList = users.findWithId(Integer.parseInt(request.getParameter("username")));
                                        for (Users u : userList) {
                                    %>
                                    <form action="FrontServlet">
                                        <form class="form">
                                            <div class ="form-group">
                                                <label>Nombre:</label>
                                                <div class="col-10">
                                                    <input type="text" class="form-control form-control-lg rounded-0" name="nameUser" value="<%=u.getNameUser()%>"><br>
                                                </div>
                                            </div>

                                            <div class ="form-group">
                                                <label>Apellidos:</label>
                                                <div class="col-10">
                                                    <input type="text" class="form-control form-control-lg rounded-0" name="surnameUser" value="<%=u.getSurnameUser()%>"><br>
                                                </div>
                                            </div>

                                            <div class ="form-group">
                                                <label>Nombre de usuario:</label>
                                                <div class="col-10">
                                                    <input type="text" class="form-control form-control-lg rounded-0" name="usernameUser" value="<%=u.getUsernameUser()%>" readonly><br>
                                                </div>
                                            </div>

                                            <div class ="form-group">
                                                <label >Contraseña:</label>
                                                <div class="col-10">
                                                    <input type="password" class="form-control form-control-lg rounded-0" name="passwordUser" id="password" value="<%=u.getPasswordUser()%>"><br>
                                                    <input type="checkbox" onclick="myFunction()">Mostrar contraseña
                                                </div>
                                            </div>
                                            <script>
                                                function myFunction() {
                                                    var x = document.getElementById("password");
                                                    if (x.type === "password") {
                                                        x.type = "text";
                                                    } else {
                                                        x.type = "password";
                                                    }
                                                }
                                            </script>

                                            <div class ="form-group">
                                                <label>Nombre de usuario:</label>
                                                <div class="col-10">
                                                    <input type="text" class="form-control form-control-lg rounded-0" name="userTypeForm" value="<%=u.getTypeUser()%>"><br>
                                                </div>
                                            </div>
  
                                            <!--<button name='confirmar' value='confirmar'>Confirmar</button>
                                            <button name='ver' value='ver'>Ver</button>-->
                                            <input type="hidden" name="id" value="<%=u.getIdUser()%>">
                                            <input type="submit" class="btn btn-primary ml-auto" name="confirmar" value="Confirmar">
                                            <input type="hidden" name="command" value="EditUserCommand">
                                        </form>
                                    </form>  
                                    <%}

                                        /*if (request.getParameter("confirmar") != null) {
                                            users.updateUser(request.getParameter("nameUser"), request.getParameter("surnameUser"), request.getParameter("usernameUser"), request.getParameter("passwordUser"), request.getParameter("userTypeForm"), Integer.parseInt(request.getParameter("id")));
                                            response.sendRedirect("/CarHire/PrincipalManagerScreen.jsp");
                                        }*/

                                    %>
                                </div> 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp" />
    </body>
</html>
