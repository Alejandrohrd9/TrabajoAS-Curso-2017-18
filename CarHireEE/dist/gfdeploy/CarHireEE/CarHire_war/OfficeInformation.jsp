<%-- 
    Document   : OfficeInformation
    Created on : 06-may-2018, 18:26:10
    Author     : alejandrohd
--%>

<%@page import="ejb.UsersFacade"%>
<%@page import="entities.Office"%>
<%@page import="java.util.List"%>
<%@page import="ejb.OfficeFacade"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Oficinas</title>
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
        <%
            OfficeFacade office = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/OfficeFacade!ejb.OfficeFacade");

            String spageid = request.getParameter("page");
            int pagen = Integer.parseInt(spageid);
            int pageid = Integer.parseInt(spageid);
            int div = 4;
            int totalRow = office.getCountOfficePagination();
            if (pageid == 1) {

            } else {
                pageid = pageid - 1;
                pageid = pageid * div + 1;
            }%>

        <h1 class="text-center">Oficinas</h1><h6 class="text-center">Página número <%=spageid%></h6><br>

        <%
            List<Office> officesRange = office.getOfficePagination(pageid, div * pagen);
            for (Office o : officesRange) {
                String address = o.getStreetOffice() + ", " + o.getNumberOffice();
                String city = o.getCityOffice() + ", " + o.getStateOffice();

        %>
        <h5 class="text-center"><%=o.getNameOffice()%></h5>
        <div class="card">
            <div class="card-body">
                <p class="text-center">
                    <%=address%><br>
                    <%=city%><br>
                    Teléfono principal: <%=o.getTf1Office()%><br>
                    Teléfono secundario: <%=o.getTf2Office()%><br>
                </p>
            </div>
        </div><br><br>
        <%}%>




        <div class="text-center">
            <%if (pageid != 1) {%>
            <a href="OfficeInformation.jsp?page=<%=pagen - 1%>">Anterior</a>
            <%}%>
            <%for (int i = 1; i <= (totalRow / div); i++) {%>
            <a href="OfficeInformation.jsp?page=<%=i%>"><%=i%></a> 
            <%
                }
                if ((totalRow % div) != 0) {%>
            <a href="OfficeInformation.jsp?page=<%=(totalRow / div) + 1%>"><%=(totalRow / div) + 1%></a>

            <%
                }

                if (pagen < (totalRow / div)) {
            %>
            <a href="OfficeInformation.jsp?page=<%=pagen + 1%>">Siguiente</a> 
            <%}
                if (pagen == (totalRow / div)) {
                    if ((totalRow % div) != 0) {

            %>

            <a href="OfficeInformation.jsp?page=<%=pagen + 1%>">Siguiente</a> 

            <%}
                }
            %>
        </div>
        <jsp:include page="footer.jsp" />
    </body>
</html>
