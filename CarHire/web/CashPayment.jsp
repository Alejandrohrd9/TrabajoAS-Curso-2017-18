<%-- 
    Document   : CashPayment
    Created on : 06-abr-2018, 19:41:42
    Author     : alejandrohd
--%>

<%@page import="statelessBeans.PaymentController"%>
<%@page import="ejb.CashPaymentFacade"%>
<%@page import="entities.CashPayment"%>
<%@page import="entities.Rent"%>
<%@page import="ejb.RentFacade"%>
<%@page import="ejb.CarDetailsFacade"%>
<%@page import="singletonBeans.LogApp"%>
<%@page import="singletonBeans.StatisticsApp"%>
<%@page import="statefulBeans.Payment"%>
<%@page import="statefulBeans.RentProcess"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="statelessBeans.PriceCalculator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%if (session.getAttribute("usuario") == null) {
        RequestDispatcher req = request.getRequestDispatcher("/PrincipalApp.jsp");
        req.forward(request, response);
    }%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
        <link rel="stylesheet" href="/CarHire/Styles/paymentStyle.css">
        <title>Pago efectivo</title>
    </head>
    <body>
        <jsp:include page="/ComercialWebPages/headerComercial.jsp" />
        <%
            RentProcess rentprocess = (RentProcess) session.getAttribute("rentprocess");
            if (rentprocess == null) {
                rentprocess = (RentProcess) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/RentProcess!statefulBeans.RentProcess");
            }

            Payment paymentB = (Payment) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/Payment!statefulBeans.Payment");
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            LogApp logContent = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            estadisticas.addAccess("CashPayment.jsp");
            int valueKey2 = estadisticas.getValue((String) session.getAttribute("usuario"));
            valueKey2++;
            estadisticas.addUserValue((String) session.getAttribute("usuario"), valueKey2);
            logContent.logGenerator("CashPayment::::" + (String) session.getAttribute("usuario"));
        %>
        <h3 class="text-center title">Proceso de pago</h3>
        <pre class="text-center"><%=rentprocess.verData((String) session.getAttribute("usuario"))%></pre>
        <main class="page payment-page">
            <section class="payment-form">
                <div class="container">
                    <div class="block-heading">
                    </div>
                    <form>
                        <%
                            RentFacade rent = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/RentFacade!ejb.RentFacade");
                            PriceCalculator priceC = (PriceCalculator) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/PriceCalculator!statelessBeans.PriceCalculator");
                            String precio = (String) session.getAttribute("priceCar");
                            String[] precioArray = precio.split("\\.");
                            String totalPrice = String.valueOf(priceC.calculatePriceDays(precioArray[0], (String) session.getAttribute("daysS"), (String) session.getAttribute("usuario")));
                            session.setAttribute("totalPrice", totalPrice);
                            Rent carData = rent.getValuesFromDNI((String) session.getAttribute("pasaporte"));
                        %>
                        <h4 class="title text-center">Importe total:<%=totalPrice%>€</h4>
                        <div class="card-details">
                            <h3 class="title">Proceso de pago en efectivo</h3>
                            <div class="row">
                                <div class="form-group col-sm-8">
                                    <label for="card-number">Entregado</label>
                                    <input name="entregado" id="card-number" type="text" class="form-control" placeholder="Entregado" aria-label="" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group">
                                    <input type="submit" class="btn btn-secondary" name="cancelarPago" value="Cancelar">
                                    <input type="submit" class="btn btn-primary ml-auto" name="pago" value="Realizar pago">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </section>
        </main>
        <%
            if (request.getParameter("pago") != null && request.getParameter("entregado") != null) {
                PaymentController paymentController = (PaymentController) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/PaymentController!statelessBeans.PaymentController");
                String deliverClient = String.valueOf(paymentController.returnMoney((String) session.getAttribute("totalPrice"), request.getParameter("entregado")));
                
                CashPaymentFacade cashPaymentF = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/CashPaymentFacade!ejb.CashPaymentFacade");
                CashPayment cash = new CashPayment();
                cash.setTotalCost(totalPrice);
                cash.setPaidOut(request.getParameter("entregado"));
                cash.setReturned(deliverClient);
                cash.setIdRentCar(carData);
                cashPaymentF.create(cash);
                
                response.sendRedirect("/CarHire/PrincipalComercialScreen.jsp");
            }

            if (request.getParameter("cancelarPago") != null) {
                paymentB.removeCard();
                response.sendRedirect("/CarHire/NewRent.jsp");
            }
        %>

        <jsp:include page="footer.jsp" />
    </body>
</html>
