<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="it.polito.ai.businesslogic.TravelDocument"%>
<%@ page import="java.net.*"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="paymentService"
	class="it.polito.ai.businesslogic.PaymentServiceImpl" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<base
	href="<%=new URL(request.getScheme(), request.getServerName(), request.getServerPort(),
					request.getContextPath())%>/">
<title>${title}</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></link>
<link rel="stylesheet" href="css/style.css"></link>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
</head>
<body>
	<div id="pageheader" class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<%@include file="../components/navbar.jsp"%>
		</div>
	</div>
	<div class="container" style="padding-top: 100px; padding-left: 250px">
		<div id="body" class="row">
			<%
				if (paymentService.getCartItems() == null || paymentService.getCartItems().size() == 0) {
			%>
			<div>
				<p class="lead">Impossibile effettuare il pagamento. Il carrello
					è vuoto!</p>
			</div>
			<%
				} else {
			%>
			<div class="col-sm-4">
				<%
					Set<TravelDocument> travelDocuments = (Set<TravelDocument>) request.getServletContext()
								.getAttribute("travelDocuments");

						for (Map.Entry<String, Integer> item : paymentService.getCartItems().entrySet()) {
							TravelDocument tFound = null;
							for (TravelDocument t : travelDocuments) {
								if (t.getId().equals(item.getKey())) {
									tFound = t;
								}
							}

							if (tFound != null) {
				%>
				<div class="panel panel-default">
					<div class="panel-heading"><%=tFound.getName()%></div>
					<div class="panel-body row">
						<div class="col-sm-9"><%=item.getValue()%></div>
					</div>
				</div>
				<%
						}
					}
				%>
			</div>
			<div class="col-sm-4">
				<form method="POST" action="private/checkout/actions?type=do"
					enctype="application/x-www-form-urlencoded">
					<div class="form-group row">
						<label for="method">Metodo:</label> <input type="text"
							required="required" name="method" class="form-control">
					</div>
					<div class="form-group row">
						<label for="creditCard">Carta di credito:</label> <input
							required="required" title="Three letter country code" type="text"
							name="creditCard" class="form-control">
					</div>
					<div class="form-group row">
						<label for="billingAddress">Indirizzo di fattura:</label> <input
							type="text" required="required" name="billingAddress"
							class="form-control">
					</div>
					<div class="form-group row">
						<label for="city">Città:</label> <input type="text"
							required="required" name="city" class="form-control">
					</div>
					<div class="form-group row">
						<label for="cap">CAP:</label> <input type="number"
							required="required" name="cap" class="form-control">
					</div>
					<div class="form-group row">
						<label for="organization">Organizzazione:</label> <input
							type="text" name="organization" class="form-control">
					</div>
					<button class="btn btn-primary" type="submit">Checkout</button>
				</form>
			</div>
			<%
				}
			%>
		</div>
		<div id="pagefooter" class="row">
			<%@include file="../components/footer.jsp"%>
		</div>
	</div>

	<script>
		$(document).ready(function() {
			$('[data-toggle="popover"]').popover();
		});
	</script>
</body>
</html>