<%-- 
    Document   : PaymentProcess
    Created on : 31-mar-2018, 0:12:24
    Author     : alejandrohd
--%>

<%@page import="entities.CreditPayment"%>
<%@page import="ejb.CreditPaymentFacade"%>
<%@page import="entities.Rent"%>
<%@page import="ejb.RentFacade"%>
<%@page import="statelessBeans.PriceCalculator"%>
<%@page import="singletonBeans.LogApp"%>
<%@page import="singletonBeans.StatisticsApp"%>
<%@page import="statefulBeans.Payment"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="statefulBeans.RentProcess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%if (session.getAttribute("usuario") == null) {
        RequestDispatcher req = request.getRequestDispatcher("/PrincipalApp.jsp");
        req.forward(request, response);
    }%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
        <link rel="stylesheet" href="/CarHire/Styles/paymentStyle.css">
        <title>Página de pago</title>
    </head>
    <body>
        <jsp:include page="/ComercialWebPages/headerComercial.jsp" />
        <%
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            LogApp logContent = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            estadisticas.addAccess("PaymentProcess.jsp");
            int valueKeyPay = estadisticas.getValue((String) session.getAttribute("usuario"));
            valueKeyPay++;
            estadisticas.addUserValue((String) session.getAttribute("usuario"), valueKeyPay);
            logContent.logGenerator("PaymentProcess::::"+(String) session.getAttribute("usuario"));
                
            RentProcess rentprocess = (RentProcess) session.getAttribute("rentprocess");
            if (rentprocess == null) {
                rentprocess = (RentProcess) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/RentProcess!statefulBeans.RentProcess");
            }

            Payment paymentB = (Payment) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/Payment!statefulBeans.Payment");

        %>
        <h3 class="text-center title">Proceso de pago</h3>
        
        <pre class="text-center"><%=rentprocess.verData((String) session.getAttribute("usuario"))%></pre>
        <main class="page payment-page">
            <section class="payment-form">
                <div class="container">
                    <div class="block-heading">
                    </div>
                    <form>
                        <%  RentFacade rent = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/RentFacade!ejb.RentFacade");
                            PriceCalculator priceC = (PriceCalculator) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/PriceCalculator!statelessBeans.PriceCalculator");
                            String precio = (String) session.getAttribute("priceCar");
                            String[] precioArray = precio.split("\\.");
                            String totalPrice = String.valueOf(priceC.calculatePriceDays(precioArray[0], (String) session.getAttribute("daysS"), (String) session.getAttribute("usuario")));
                            session.setAttribute("totalPrice", totalPrice);
                            Rent carData = rent.getValuesFromDNI((String) session.getAttribute("pasaporte"));
                            
                        %>
                        <h4 class="title text-center">Importe total:<%=totalPrice%>€</h4>
                        <div class="card-details">
                            <h3 class="title">Detalles de la tarjeta de crédito</h3>
                            <div class="row">
                                <div class="form-group col-sm-7">
                                    <label for="card-holder">Tipo de tarjeta</label>
                                    <!--<input id="card-holder" type="text" class="form-control" placeholder="Card Holder" aria-label="Card Holder" aria-describedby="basic-addon1">-->
                                    <select name="sel2CC" class="form-control" id="sel2CC">
                                        <option>Visa</option>
                                        <option>MasterCard</option>
                                    </select>
                                </div>
                                <div class="form-group col-sm-5">
                                    <label for="">Fecha de expiracion</label>
                                    <div class="input-group expiration-date">
                                        <input type="text" name="month" class="form-control" placeholder="MM" aria-label="MM" aria-describedby="basic-addon1">
                                        <span class="date-separator">/</span>
                                        <input type="text" name="year" class="form-control" placeholder="YY" aria-label="YY" aria-describedby="basic-addon1">
                                    </div>
                                </div>
                                <div class="form-group col-sm-8">
                                    <label for="card-number">Número de la tarjeta</label>
                                    <input name="cardN" id="card-number" type="text" class="form-control" placeholder="Número de la tarjeta" aria-label="Número de la tarjeta" aria-describedby="basic-addon1">
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
            if (request.getParameter("pago") != null) {
                CreditPaymentFacade creditPayment = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/CreditPaymentFacade!ejb.CreditPaymentFacade");
                CreditPayment creditP = new CreditPayment();
                creditP.setNumberCredit(request.getParameter("cardN"));
                String dateCredit = request.getParameter("month")+"/"+request.getParameter("year");
                creditP.setDateCredit(dateCredit);
                creditP.setTotalCredit(totalPrice);
                creditP.setIdCarRent(carData);
                creditPayment.create(creditP);
                /*paymentB.addTotalPrice((String) session.getAttribute("totalPrice"),(String) session.getAttribute("usuario"));
                paymentB.addReturnMoney("0", (String)session.getAttribute("usuario"));
                paymentB.addTypeCard(request.getParameter("sel2CC"),(String)session.getAttribute("usuario"));
                paymentB.addNumber(request.getParameter("cardN"),(String)session.getAttribute("usuario"));
                paymentB.addCardMonth(request.getParameter("month"),(String)session.getAttribute("usuario"));
                paymentB.addCardYear(request.getParameter("year"),(String)session.getAttribute("usuario"));
                
                session.setAttribute("paymentB", paymentB);*/
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
