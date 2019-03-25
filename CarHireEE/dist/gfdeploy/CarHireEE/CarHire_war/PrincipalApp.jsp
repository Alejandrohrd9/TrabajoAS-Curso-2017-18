<%-- 
    Document   : PrincipalApp
    Created on : 18-feb-2018, 20:45:53
    Author     : alejandrohd
--%>

<%@page import="javax.naming.InitialContext"%>
<%@page import="singletonBeans.StatisticsApp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sesión</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js" integrity="sha384-feJI7QwhOS+hwpX2zkaeJQjeiwlhOP+SdQDqhgvvo1DsjtiSQByFdThsxO669S2D" crossorigin="anonymous"></script>
    </head>
    <body>
        <h2 class="text-center">Car Hire: Software para empresas</h2>
        <%if(session.getAttribute("usuario") == null){%>
        <div class="container py-5">
            <div class="row">
                <div class="col-md-12">
                    <div class="row">
                        <div class="col-md-6 mx-auto">
                            <div class="card rounded-0">
                            <div class="card-header">
                                <h3 class="mb-0">Inicio de sesión</h3>
                            </div>
                        <div class="card-body">
                            <form action="FrontServlet" class="form" role="form" autocomplete="off" id="formLogin" novalidate="" method="POST">
                                <div class="form-group">
                                    <label for="uname1">Nombre de Usuario</label>
                                    <input type="text" class="form-control form-control-lg rounded-0" name="username" id="uname1" required>
                                <!--<div class="invalid-feedback">Usuario o contraseña incorrecta.</div>-->
                                </div>
                                <div class="form-group">
                                    <label>Contraseña</label>
                                    <input type="password" name="pass" class="form-control form-control-lg rounded-0" id="pwd1" required autocomplete="new-password">
                                    <div class="invalid-feedback">Introduzca la contraseña</div>
                                </div>
                                <input type="hidden" name="command" value="LoginCommand">
                                <button type="submit" class="btn btn-success btn-lg float-right" id="btnLogin">Acceder</button>
                                </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
       
        <%}else{%>
            <jsp:forward page="PrincipalManagerScreen.jsp" />
        <%}%>
    </body>
</html>
