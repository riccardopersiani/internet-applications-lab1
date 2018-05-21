<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="it.polito.ai.businesslogic.TravelDocument"%>
<%@ page import="java.net.*"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="cartService" 
	class="it.polito.ai.businesslogic.CartServiceImpl" scope="session">
</jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<base href="<%=new URL(request.getScheme(), request.getServerName(), request.getServerPort(), request.getContextPath())%>/">
	<title>${title}</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></link>
	<link rel="stylesheet" href="css/style.css"></link>
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="pageheader" class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<%@include file="components/navbar.jsp"%>
		</div>
	</div>
	<div class="container" style="padding-top: 50px; padding-left: 250px">
		<div id="body" class="row" style="padding-top: 100px;">
			<%
				if (cartService.getItems().size() == 0)
				{
			%>
					<div>
						<p class="lead">Il carrello è vuoto</p>
					</div>
			<%		
				}
				else
				{
			%>
					<div>
						<p class="lead">Totale: <%=cartService.getTotal() %> €</p>
					</div>
			<%
					Set<TravelDocument> travelDocuments = (Set<TravelDocument>) request.getServletContext()
							.getAttribute("travelDocuments");
	
					for (Map.Entry<String, Integer> item : cartService.getItems().entrySet())
					{
						TravelDocument tFound = null;
						for (TravelDocument t : travelDocuments)
						{
							if (t.getId().equals(item.getKey()))
							{
								tFound = t;
							}
						}
						
						if (tFound != null)
						{
			%>
							<div class="panel panel-default">
								<div class="panel-heading"><%=tFound.getName()%></div>
								<div class="panel-body row">
									<div class="col-sm-9">
										<form action="cart/actions?type=modify" method="POST"
											enctype="application/x-www-form-urlencoded">
											<input hidden="true" name="type" value="modify">
											<label class="control-label col-sm-2" for="firstName">Quantità:</label>
											<input type="number" name="quantity" value="<%=item.getValue()%>">
											<input hidden="true" name="travelDocumentId" value="<%=tFound.getId()%>">
											<button type="submit" class="btn">Aggiorna</button>
										</form>
									</div>
									<div class="col-sm-3">
										<form action="cart/actions?type=remove" method="POST"
											enctype="application/x-www-form-urlencoded">
											<input hidden="true" name="type" value="delete">
											<input hidden="true" name="travelDocumentId"
												value="<%=tFound.getId()%>">
											<button type="submit" class="btn">Rimuovi</button>
										</form>
									</div>
								</div>
							</div>
			<%
						}
					}
			%>

					<form method="POST" action="private/checkout/actions?type=create">
						<button class="btn btn-primary" type="submit">Checkout</button>
					</form>

			<%
				}
			%>
			
		</div>
		<div id="pagefooter" class="row">
			<%@include file="components/footer.jsp"%>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$('[data-toggle="popover"]').popover();
		});
	</script>
</body>
</html>