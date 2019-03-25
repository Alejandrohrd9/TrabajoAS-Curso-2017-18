<%-- 
    Document   : ViewMessages
    Created on : 09-may-2018, 15:27:04
    Author     : alejandrohd
--%>

<%@page import="ejb.UsersFacade"%>
<%@page import="entities.Messages"%>
<%@page import="java.util.List"%>
<%@page import="ejb.MessagesFacade"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Historial de mensajes</title>
    </head>
    <body>
        <%
            UsersFacade users = (UsersFacade) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/UsersFacade!ejb.UsersFacade");
        %>
        <%if (users.getTypeUser((String) session.getAttribute("usuario"), (String) session.getAttribute("password")).equals("Comercial")) {%>
        <jsp:include page="/ComercialWebPages/headerComercial.jsp"/>
        <%} else {%>
        <jsp:include page="header.jsp" />
        <%}%>
        <h3 class="text-center"> Historial de mensajes</h3>
        <%MessagesFacade mF = (MessagesFacade) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/MessagesFacade!ejb.MessagesFacade");

            if (request.getParameter("search") == null) {
                response.sendRedirect("Messages.jsp");
            } else {
                List<Messages> messagesList = mF.getMessageUser(request.getParameter("search"));%>

        <%for (Messages m : messagesList) {%>
        <p class="text-center"><%="Usuario: " + m.getNameUser() + "  Mensaje: " + m.getTextMessage() + "  Fecha: " + m.getDateMessage()%>
        </p>
        <%}

            }
        %>

        <jsp:include page="footer.jsp" />
    </body>
</html>
