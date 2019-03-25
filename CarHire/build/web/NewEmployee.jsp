<%-- 
    Document   : NewEmployee
    Created on : 03-may-2018, 19:30:31
    Author     : alejandrohd
--%>

<%@page import="ejb.UsersFacade"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html">
        <title>Nuevo empleado</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <h3 class="text-center title">Nuevo empleado</h3>
        <div class="container py-5">
            <div class="row">
                <div class="col-md-12">
                    <div class="row">
                        <div class="col-md-8 mx-auto">
                            <div class="card rounded-0">
                                <div class="card-body">
                                    <form class="form">
                                        <div class ="form-group">
                                            <label>Nombre:</label>
                                            <div class="col-10">
                                                <input type="text" class="form-control form-control-lg rounded-0" name="nameUser" value=""><br>
                                            </div>
                                        </div>

                                        <div class ="form-group">
                                            <label>Apellidos:</label>
                                            <div class="col-10">
                                                <input type="text" class="form-control form-control-lg rounded-0" name="surnameUser"><br>
                                            </div>
                                        </div>

                                        <div class ="form-group">
                                            <label>Nombre de usuario:</label>
                                            <div class="col-10">
                                                <input type="text" class="form-control form-control-lg rounded-0" name="usernameUser"><br>
                                            </div>
                                        </div>

                                        <div class ="form-group">
                                            <label >Contraseña:</label>
                                            <div class="col-10">
                                                <input type="password" class="form-control form-control-lg rounded-0" name="passwordUser" id="password"><br>
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
                                            <label>Repetir contraseña:</label>
                                            <div class="col-10">
                                                <input type="password" class="form-control form-control-lg rounded-0" name="repeatpassword" id="confirm_password"><br>
                                            </div>
                                        </div>
                                        <script>
                                            var password = document.getElementById("password")
                                                    , confirm_password = document.getElementById("confirm_password");

                                            function validatePassword() {
                                                if (password.value != confirm_password.value) {
                                                    confirm_password.setCustomValidity("La contraseña no coincide");
                                                } else {
                                                    confirm_password.setCustomValidity('');
                                                }
                                            }

                                            password.onchange = validatePassword;
                                            confirm_password.onkeyup = validatePassword;
                                        </script>

                                        <div class="form-group">
                                            <label for="sel1">Tipo de usuario:</label>
                                            <select class="form-control" name="userTypeForm" id="userPayForm">
                                                <option>Gerente</option>
                                                <option>Comercial</option>
                                            </select>
                                        </div>    

                                        <!--<button name='confirmar' value='confirmar'>Confirmar</button>
                                        <button name='ver' value='ver'>Ver</button>-->
                                        <div class="input-group">
                                            <input type="submit" class="btn btn-secondary" name="cancelar" value="Cancelar">
                                            <input type="submit" class="btn btn-primary ml-auto" name="confirmar" value="Confirmar">
                                        </div>
                                    </form>  
                                    <%            UsersFacade users = (UsersFacade) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/UsersFacade!ejb.UsersFacade");
                                        if (request.getParameter("cancelar") != null) {
                                            response.sendRedirect("/CarHire/PrincipalManagerScreen.jsp");
                                        }

                                        if (request.getParameter("confirmar") != null) {
                                            if (users.findWithUser(request.getParameter("usernameUser")).isEmpty()) {
                                                users.insertUser(request.getParameter("nameUser"), request.getParameter("surnameUser"), request.getParameter("usernameUser"), request.getParameter("passwordUser"), request.getParameter("userTypeForm"));
                                                response.sendRedirect("/CarHire/PrincipalManagerScreen.jsp");
                                            } else {
                                                System.out.println("Por el modal");

                                            }
                                        }
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
