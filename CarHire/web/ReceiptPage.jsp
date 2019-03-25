<%-- 
    Document   : ReceiptPage
    Created on : 03-abr-2018, 18:30:40
    Author     : alejandrohd
--%>

<%@page import="statefulBeans.RentDone"%>
<%@page import="statelessBeans.PaymentController"%>
<%@page import="singletonBeans.LogApp"%>
<%@page import="singletonBeans.StatisticsApp"%>
<%@page import="statefulBeans.Payment"%>
<%@page import="statefulBeans.RentProcess"%>
<%@page import="statefulBeans.Receipt"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%if (session.getAttribute("usuario") == null) {
        RequestDispatcher req = request.getRequestDispatcher("/PrincipalApp.jsp");
        req.forward(request, response);
    }%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factura</title>
    </head>
    <body>
        <jsp:include page="/ComercialWebPages/headerComercial.jsp" />
        <%
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            LogApp logContent = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            estadisticas.addAccess("ReceiptPage.jsp");
            int valueKeyReceipt = estadisticas.getValue((String) session.getAttribute("usuario"));
            valueKeyReceipt++;
            estadisticas.addUserValue((String) session.getAttribute("usuario"), valueKeyReceipt);
            logContent.logGenerator("ReceiptPage::::"+(String) session.getAttribute("usuario"));

            Receipt receiptClient = (Receipt) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/Receipt!statefulBeans.Receipt");
            RentProcess rentprocess = (RentProcess) session.getAttribute("rentprocess");

            Payment paymentInfo = (Payment) session.getAttribute("paymentB");
            if (session.getAttribute("payForm").equals("Tarjeta")) {
                if (paymentInfo == null) {
                    paymentInfo = (Payment) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/Payment!statefulBeans.Payment");
                }
                receiptClient.addDataCard(paymentInfo.verDataCredit((String) session.getAttribute("usuario")), (String) session.getAttribute("usuario"));
            }
            if (session.getAttribute("payForm").equals("Efectivo")) {
                System.out.println("Efectivo");
                if (paymentInfo == null) {
                    paymentInfo = (Payment) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/Payment!statefulBeans.Payment");
                }
                PaymentController paymentController = (PaymentController) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/PaymentController!statelessBeans.PaymentController");
                String deliverClient = String.valueOf(paymentController.returnMoney((String) session.getAttribute("totalPrice"), (String) session.getAttribute("moneyDelivered")));
                paymentInfo.addReturnMoney(deliverClient, (String) session.getAttribute("usuario"));

                receiptClient.addPrice(paymentInfo.verPrecio((String) session.getAttribute("usuario")), (String) session.getAttribute("usuario"));
            }

            receiptClient.addDataRent(rentprocess.verData((String) session.getAttribute("usuario")), (String) session.getAttribute("usuario"));
            String[] receiptList = receiptClient.listReceiptToArray((String) session.getAttribute("usuario"));
            String receiptGenerated = "";
            for (int i = 0; i < receiptList.length; i++) {
                receiptGenerated += receiptList[i] + "\n";
            }

        %>
        <h3 class="text-center">Factura</h3>
        <pre class="text-center"><%=receiptGenerated%>
        <div class="">
                <%
                    RentDone rentFinished = (RentDone) session.getAttribute("rentFinished");
                    if (rentFinished == null) {
                        rentFinished = (RentDone) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/RentDone!statefulBeans.RentDone");
                    }

                %>
                <form>
                    <center>
                    <input type="submit" class="btn btn-primary ml-auto" name="guardar" value="Guardar">
                    </center>
                </form>
        </div>
        </pre>
        <%if (request.getParameter("guardar") != null) {
                rentFinished.setRentCompleted(receiptGenerated, (String) session.getAttribute("pasaporte"), (String) session.getAttribute("usuario"));
                session.setAttribute("rentFinished", rentFinished);
                response.sendRedirect("/CarHire/PrincipalComercialScreen.jsp");

            }%>
        <jsp:include page="footer.jsp" />
    </body>
</html>
