<%-- 
    Document   : headerComercial.jsp
    Created on : 30-mar-2018, 12:38:46
    Author     : alejandrohd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js" integrity="sha384-feJI7QwhOS+hwpX2zkaeJQjeiwlhOP+SdQDqhgvvo1DsjtiSQByFdThsxO669S2D" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="/CarHire/Styles/style.css">
        <script defer src="/CarHire/Styles/fontawesome/fontawesome-all.js"></script>
    </head>
    <body>
        <h2 class="text-center">Car Hire: Software para empresas</h2>
        <div class="navbar navbar-expand-lg navbar-dark bg-dark">
            <nav class="container-fluid">
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar2" aria-controls="navbar2" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <a class="navbar-brand" href="#">Car Hire!</a>
                <div class="collapse navbar-collapse justify-content-between" id="navbar2">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="btn btn-dark" class="nav-link" href="PrincipalComercialScreen.jsp">Inicio</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="btn btn-dark" class="nav-link dropdown-toggle"  data-toggle="dropdown" id="Preview" href="#" role="button" aria-haspopup="true" aria-expanded="false">Alquiler</a>
                            <div class="dropdown-menu" aria-labelledby="Preview">
                                <a class="dropdown-item" href="NewRent.jsp">Nuevo alquiler</a>
                                <a class="dropdown-item" href="ViewRents.jsp">Alquileres realizados</a>
                                <a class="dropdown-item" href="OnlineRents.jsp">Reservas Online</a>
                            </div>
                        </li>

                        <li class="nav-item">
                            <form action="FrontServlet">
                                <input type="hidden" name="command" value="ViewPlanningCommand">
                                <input type="submit" class="btn btn-dark" class="nav-link" value="Planning">
                            </form>
                        </li>
                        <li class="nav-item">
                            <a class="btn btn-dark" class="nav-link" href="OfficeInformation.jsp?page=1">Oficinas</a>
                        </li>
                        <li class="nav-item">
                            <a class="btn btn-dark" class="nav-link" href="ViewDistributor.jsp">Distribuidor</a>
                        </li>
                    </ul>
                    <ul class="navbar-nav ml-auto">
                        <form action="Messages.jsp">
                            <input type="submit" class="btn btn-dark" class="nav-link" value="Mensajería">
                        </form>
                        <form action="ViewLog.jsp">
                            <input type="submit" class="btn btn-dark" class="nav-link" value="Log">
                        </form>
                        <a class="navbar-brand" href="#">¡Bienvenido, <%=session.getAttribute("usuario")%>!</a>
                    </ul>
                    <% if (session.getAttribute("usuario") != null) {%>
                    <form action="Logout.jsp" class="form-inline my-2 my-lg-0">
                        <input type="hidden" name="logout">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Cerrar sesión</button>
                    </form>
                    <%}%>
                </div>
            </nav>
        </div>
    </body>
</html>

