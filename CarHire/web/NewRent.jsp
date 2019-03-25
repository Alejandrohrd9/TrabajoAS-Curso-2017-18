<%-- 
    Document   : NewRent
    Created on : 31-mar-2018, 0:44:46
    Author     : alejandrohd
--%>

<%@page import="entities.CarDetails"%>
<%@page import="ejb.CarDetailsFacade"%>
<%@page import="entities.Rent"%>
<%@page import="ejb.RentFacade"%>
<%@page import="entities.Car"%>
<%@page import="java.util.List"%>
<%@page import="ejb.CarFacade"%>
<%@page import="singletonBeans.CarCatalog"%>
<%@page import="singletonBeans.LogApp"%>
<%@page import="singletonBeans.StatisticsApp"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html"%>
<%@page import="statefulBeans.RentProcess"%>
<%@page import="statefulBeans.Payment"%>
<%if (session.getAttribute("usuario") == null) {
        RequestDispatcher req = request.getRequestDispatcher("/PrincipalApp.jsp");
        req.forward(request, response);
    }%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html">
        <title>Nuevo alquiler</title>
    </head>
    <body>
        <jsp:include page="/ComercialWebPages/headerComercial.jsp" />
        <%

            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            LogApp logContent = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            estadisticas.addAccess("NewRent.jsp");
            int valueKeyNewR = estadisticas.getValue((String) session.getAttribute("usuario"));
            valueKeyNewR++;
            estadisticas.addUserValue((String) session.getAttribute("usuario"), valueKeyNewR);
            logContent.logGenerator("NewRent::::" + (String) session.getAttribute("usuario"));
            RentProcess rentprocess = (RentProcess) session.getAttribute("rentprocess");
            if (rentprocess == null) {
                rentprocess = (RentProcess) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/RentProcess!statefulBeans.RentProcess");
            }

            CarCatalog carsCatalog = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/CarCatalog!singletonBeans.CarCatalog");
            String[] arrayCars = carsCatalog.catalogArray((String) session.getAttribute("usuario"));
            CarFacade cars = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/CarFacade!ejb.CarFacade");
        
            RentFacade rent = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/RentFacade!ejb.RentFacade");
            CarDetailsFacade carDetails = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/CarDetailsFacade!ejb.CarDetailsFacade");
        %>

        <h3 class="text-center title">Nuevo alquiler</h3>
        <div class="container py-5">
            <div class="row">
                <div class="col-md-12">
                    <div class="row">
                        <div class="col-md-8 mx-auto">
                            <div class="card rounded-0">
                                <div class="card-body">
                                    <form class="form">
                                        <div class ="form-group">
                                            <label>Comercial:</label>
                                            <div class="col-10">
                                                <input type="text" class="form-control form-control-lg rounded-0" name="comercialName" value="<%=session.getAttribute("usuario")%>"><br>
                                            </div>
                                        </div>

                                        <div class ="form-group">
                                            <label>Nombre del cliente:</label>
                                            <div class="col-10">
                                                <input type="text" class="form-control form-control-lg rounded-0" name="nombreaped"><br>
                                            </div>
                                        </div>

                                        <div class ="form-group">
                                            <label>Dirección:</label>
                                            <div class="col-10">
                                                <input type="text" class="form-control form-control-lg rounded-0" name="direccion"><br>
                                            </div>
                                        </div>

                                        <div class ="form-group">
                                            <label >Nacionalidad:</label>
                                            <div class="col-10">
                                                <input type="text" class="form-control form-control-lg rounded-0" name="nacionalidad"><br>
                                            </div>
                                        </div>

                                        <div class ="form-group">
                                            <label>DNI:</label>
                                            <div class="col-10">
                                                <input type="text" class="form-control form-control-lg rounded-0" name="pasaporte"><br>
                                            </div>
                                        </div>

                                        <div class ="form-group">
                                            <label>Fecha de nacimiento:</label>
                                            <div class="col-10">
                                                <input type="text" class="form-control form-control-lg rounded-0" name="nacimiento"><br>
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <label for="example-search-input" class="col-2 col-form-label">Nº permiso conducir:</label>
                                            <div class="col-10">
                                                <input type="text" class="form-control form-control-lg rounded-0" name="permiso" value=""><br>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="sel1">Vehículo:</label>
                                            <select class="form-control" name="sel1" id="sel1">
                                                <%List<Car> carsSelect = cars.findAll();
                                                    for (Car c : carsSelect) {%>
                                                <option><%=c.getMarcaC()+" "+c.getModelC()%></option>
                                                <%}
                                                %>
                                            </select>
                                        </div> 

                                        <div class="form-group">
                                            <label for="example-search-input" class="col-2 col-form-label">Días:</label>
                                            <div class="col-10">
                                                <input type="days" class="form-control form-control-lg rounded-0" name="days" value=""><br>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="sel1">Forma de pago:</label>
                                            <select class="form-control" name="payForm" id="payForm">
                                                <option>Efectivo</option>
                                                <option>Tarjeta</option>
                                            </select>
                                        </div>    

                                        <!--<button name='confirmar' value='confirmar'>Confirmar</button>
                                        <button name='ver' value='ver'>Ver</button>-->
                                        <div class="input-group">
                                            <input type="submit" class="btn btn-secondary" name="cancelar" value="Cancelar">
                                            <input type="submit" class="btn btn-primary ml-auto" name="confirmar" value="Confirmar">
                                        </div>
                                    </form>  
                                </div> 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%
            if (request.getParameter("confirmar") != null) {
                String price = null;
                String[] car = (request.getParameter("sel1").split("\\s+"));
                List<CarDetails> detallesCoche = carDetails.findAll();
                for (CarDetails c : detallesCoche) {
                    System.out.println(c.getIdCarModel().getModelC());
                    if(c.getIdCarModel().getModelC().equals(car[1])){
                        price=c.getPriceCar().toString();
                        session.setAttribute("priceCar", price);
                        break;
                        
                    }
                }
                
                Rent newRent = new Rent();
                newRent.setComercial(request.getParameter("comercialName"));
                newRent.setNameClient(request.getParameter("nombreaped"));
                newRent.setAddressClient(request.getParameter("direccion"));
                newRent.setDniClient(request.getParameter("pasaporte"));
                newRent.setBornClient(request.getParameter("nacimiento"));
                newRent.setLicenseClient(request.getParameter("permiso"));
                newRent.setCarClient(request.getParameter("sel1"));
                newRent.setDays(request.getParameter("days"));
                newRent.setWayToPay(request.getParameter("payForm"));
                rent.create(newRent);
                
                rentprocess.addClientName(request.getParameter("nombreaped"), (String) session.getAttribute("usuario"));
                rentprocess.addClientAddress(request.getParameter("direccion"), (String) session.getAttribute("usuario"));
                rentprocess.addNationality(request.getParameter("nacionalidad"), (String) session.getAttribute("usuario"));
                rentprocess.addPassportNumber(request.getParameter("pasaporte"), (String) session.getAttribute("usuario"));
                rentprocess.addBirth(request.getParameter("nacimiento"), (String) session.getAttribute("usuario"));
                rentprocess.addLicenseNum(request.getParameter("permiso"), (String) session.getAttribute("usuario"));
                rentprocess.addCar(request.getParameter("sel1"), (String) session.getAttribute("usuario"));
                rentprocess.addPayForm(request.getParameter("payForm"), (String) session.getAttribute("usuario"));
                rentprocess.addDays(request.getParameter("days"), (String) session.getAttribute("usuario"));

                /*String[] car = (request.getParameter("sel1").split("\\s+"));
                session.setAttribute("priceCar", car[2]);*/
                session.setAttribute("daysS", request.getParameter("days"));
                session.setAttribute("rentprocess", rentprocess);
                session.setAttribute("payForm", request.getParameter("payForm"));
                session.setAttribute("pasaporte", request.getParameter("pasaporte"));
                if (request.getParameter("payForm").equals("Tarjeta")) {
                    response.sendRedirect("/CarHire/PaymentProcess.jsp");
                } else {
                    response.sendRedirect("/CarHire/CashPayment.jsp");
                }
        %>

        <%}

            if (request.getParameter("cancelar") != null) {
                rentprocess.removeData();
                response.sendRedirect("/CarHire/PrincipalComercialScreen.jsp");

            }
        %>

        <jsp:include page="/footer.jsp" />
    </body>
</html>
