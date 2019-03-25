<%-- 
    Document   : ViewDistributor
    Created on : 09-may-2018, 17:35:20
    Author     : alejandrohd
--%>

<%@page import="java.util.List"%>
<%@page import="entities.Distributor"%>
<%@page import="ejb.DistributorFacade"%>
<%@page import="ejb.UsersFacade"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Distribuidores</title>
    </head>
    <body>
        <%
            UsersFacade users = (UsersFacade) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/UsersFacade!ejb.UsersFacade");
            DistributorFacade distributor = (DistributorFacade) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/DistributorFacade!ejb.DistributorFacade");
        %>
        <%if (users.getTypeUser((String) session.getAttribute("usuario"), (String) session.getAttribute("password")).equals("Comercial")) {%>
        <jsp:include page="/ComercialWebPages/headerComercial.jsp"/>
        <%} else {%>
        <jsp:include page="header.jsp" />
        <%}%>
        <h3 class="text-center">Distribuidores</h3>
        <%List<Distributor> distributorContanct = distributor.findAll();
            for (Distributor d : distributorContanct) {
                String address = d.getAddressD() + ", " + d.getCityD();%>
        <h5 class="text-center"><%=d.getNameD()%></h5>
        <div class="card">
            <div class="card-body">
                <p class="text-center">
                    <%=address%><br>
                    Teléfono de contacto:<%=d.getPhoneD()%><br>
                    <a href="<%=d.getUrlD()%>"><%=d.getNameD()%></a>
                </p>
            </div>
        </div><br><br>

        <%}
        %>
    </body>
</html>
