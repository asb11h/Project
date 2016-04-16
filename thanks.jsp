<%@page contentType="text/html" pageEncoding="utf-8"%>

<html lang="en">
<head>
<!--
"Time-stamp: <Sun, 04-10-16, 18:16:49 Eastern Daylight Time>"
//-->
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="My online portfolio that illustrates skills acquired while working through various project requirements.">
	<meta name="author" content="Mark K. Jowett, Ph.D.">
	<link rel="icon" href="favicon.ico">

	<title>CRSXXXX - Project2</title>

<!-- Include FontAwesome CSS to use feedback icons provided by FontAwesome -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

<!-- Bootstrap for responsive, mobile-first design. -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">

<!-- Form validation styling. -->
<link rel="stylesheet" href="css/formValidation.min.css"/>

<!-- Starter template for individual styling. -->
<link href="css/starter-template.css" rel="stylesheet">

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->

</head>
<body>

	<%@ include file="global/nav.jsp" %>	

	<div class="container">
		<div class="starter-template">
			<div class="row">
				<div class="col-sm-8 col-sm-offset-2">
					
					<div class="page-header">
						<%@ include file="global/header.jsp" %>
					</div>

					<p><a href="customerAdmin">Display Customers</a></p>
					
    <h3>Thanks for joining our customer list!</h3>

    <p>Here is the information that you entered:</p>

		<div class="col-sm-8 col-sm-offset-2 text-left">
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

			<% //<c:out... prevents cross-site scripting (XSS) attack (escapes output) %>
			<label>FName:</label> <c:out value="${customer.fname}" /> <br />
			<label>LName:</label> <c:out value="${customer.lname}" /> <br />
			<label>Email:</label> <c:out value="${customer.email}" /> <br />

			<form action="customerAdmin" method="post">
				<% // goes to admin/CustomerServlet.java %>
				<input type="hidden" name="add_customer" value="add">
				<input type="submit" value="Add">
			</form>

		</div>

				</div>
			</div>

			<%@ include file="global/footer.jsp" %>
			
	</div> <!-- end starter-template -->
 </div> <!-- end container -->

	<!-- Bootstrap JavaScript
	================================================== -->
	<!-- Placed at end of document so pages load faster -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.0.min.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="js/ie10-viewport-bug-workaround.js"></script>
		
</body>
</html>
