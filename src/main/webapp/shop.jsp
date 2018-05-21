<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="it.polito.ai.businesslogic.TravelDocument"%>
<%@ page import="java.net.*"%>
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
			<%@include file="components/navbar.jsp"%>
		</div>
	</div>
	<div class="container" style="padding-top: 100px; padding-left: 250px">
		<div id="body" class="row">
			<%
				java.util.Set<TravelDocument> travelDocuments = (java.util.Set<TravelDocument>) request.getServletContext()
						.getAttribute("travelDocuments");
				for (TravelDocument t : travelDocuments) {
			%>
			<div class="panel panel-default">
				<div class="panel-heading"><%=t.getName()%></div>
				<div class="panel-body row">
					<div class="col-sm-9"><%=t.getDescription()%></div>
					<div class="col-sm-3">
						<form action="cart/actions?type=add" method="POST"
							enctype="application/x-www-form-urlencoded">
							<button class="btn" type="submit">Aggiungi</button>
							<input type="number" name="quantity" value="1" min="1"/>
							<input value="<%=t.getId()%>" name="travelDocumentId" hidden="true"/>
							<!-- input nascosto che manda il tipo del biglietto -->
						</form>
					</div>
				</div>
			</div>
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