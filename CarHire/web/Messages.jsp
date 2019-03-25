<%-- 
    Document   : Messages
    Created on : 08-abr-2018, 14:43:55
    Author     : alejandrohd
--%>

<%@page import="ejb.UsersFacade"%>
<%@page import="ejb.MessagesFacade"%>
<%@page import="singletonBeans.MessageBean"%>
<%@page import="mdb.MessageBeanCH"%>
<%@page import="singletonBeans.LogApp"%>
<%@page import="singletonBeans.StatisticsApp"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html"%>
<%if (session.getAttribute("usuario") == null) {
        RequestDispatcher req = request.getRequestDispatcher("/PrincipalApp.jsp");
        req.forward(request, response);
    }%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html">
        <title>Mensajería</title>
    </head>
    <body>
        <%
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            LogApp logContent = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");

            estadisticas.addAccess("Messages.jsp");
            int valueKey8 = estadisticas.getValue((String) session.getAttribute("usuario"));
            valueKey8++;
            estadisticas.addUserValue((String) session.getAttribute("usuario"), valueKey8);
            logContent.logGenerator("Messages::::" + session.getAttribute("usuario"));
            MessageBean mensaje = (MessageBean) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/MessageBean!singletonBeans.MessageBean");
            UsersFacade users = (UsersFacade) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/UsersFacade!ejb.UsersFacade");
        %>
        <%if (users.getTypeUser((String)session.getAttribute("usuario"), (String)session.getAttribute("password")).equals("Comercial")) {%>
        <jsp:include page="/ComercialWebPages/headerComercial.jsp"/>
        <%} else {%>
        <jsp:include page="header.jsp" />
        <%}%>
        <h3 class="text-center">Servicio de mensajería</h3><br>
        <div class="container text-center">
            <form action="ViewMessages.jsp">
                <div class="input-group">
                    <input id="filtrar" type="text" name="search" class="form-control" placeholder="Buscar mensaje en el historial por nombre de usuario">
                    <input type="submit" class="btn btn-light" name="buscar" value="Buscar">
                </div>
            </form>
        </div><br>
        
        <form action="MDBServlet">
            Mensaje:<input type="text"  name="mensajeText">
            <input type="submit" value="Enviar">
        </form><br>



        <%/*String mensajes = "";
        for (String message : mensaje.getMessages()) {
                mensajes+=message+ "\n";
            }%*/%>
        <pre><%=mensaje.getMessages()%></pre>

        <jsp:include page="footer.jsp" />
    </body>
</html>
