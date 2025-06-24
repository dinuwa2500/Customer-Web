<%@page import="db.DBconnect"%>
<%@page import="java.util.List"%>
<%@page import="dbc.PckImpl"%>
<%@page import="dbc.PckDbc"%>
<%@page import="entity.Package"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%@include file="/allcomponents/allcss.jsp"%>
<%@include file="/allcomponents/header.jsp"%>
<style>
.hero-section {
	position: relative;
	height: 500px; /* Adjust height as needed */
	background-image:
		url('https://s3.ap-southeast-1.amazonaws.com/dlg.dialog.lk/s3fs-public/2024-07/power-plan-banner-web.jpg');
	/* Background image */
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
}

.hero-content {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	color: white;
	text-align: center;
}

.txt {
	color: black;
}

a {
	text-decoration: none ! important;
}

a:hover {
	text-decoration: none ! important;
}

.card-active {
	border: 2px solid #ef005a !important;
	background-color: #f8f9fa;
	/* Add any specific active background color */
}

/*  https://s3.ap-southeast-1.amazonaws.com/dlg.dialog.lk/s3fs-public/2024-07/power-plan-banner-web.jpg */
</style>



<meta charset="UTF-8">
<title>Packages Page | CustomerWeb</title>
</head>
<body>

	<div class="container-fluid p-0">
		<div class="hero-section">
			<div class="hero-content">
				<h1 class="display-4">lorem ipsum</h1>
				<p>lorem ipsum</p>
				<a href="#" class="btn btn-primary">Order Now</a>
			</div>
		</div>
	</div>


	<div class="postpaid-prepaid-section py-2 py-md-5">
		<div class="container">
			<div class="row justify-content-center mt-5">
				<div class="col-md-6 mb-3 mb-md-0">
					<div class="card level-2 overflow-hidden">
						<a href="../Mobile/Prepaid.jsp">
							<div class="d-flex align-items-center">
								<div>
									<h4 class="py-0 px-3 py-md-2 px-md-3 px-lg-4 txt"
										role="heading" aria-level="3">Prepaid connections</h4>
								</div>

								<div class="ml-auto">
									<img alt="Postpaid connections" class="img-fluid"
										src="https://s3.ap-southeast-1.amazonaws.com/dlg.dialog.lk/s3fs-public/2023-05/mobile-icons.png">
								</div>
							</div>
						</a>
					</div>
				</div>

				<div class="col-md-6 mb-3 mb-md-0">
					<div class="card level-2 overflow-hidden">
						<a href="../Mobile/Postpaid.jsp">
							<div class="d-flex align-items-center">
								<div>
									<h4 class="py-0 px-3 py-md-2 px-md-3 px-lg-4 txt">Postpaid
										connections</h4>
								</div>

								<div class="ml-auto">
									<img alt="Prepaid connections" class="img-fluid"
										src="https://s3.ap-southeast-1.amazonaws.com/dlg.dialog.lk/s3fs-public/2023-05/mobile-icons.png">
								</div>
							</div>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container-fluid bg-light mt-3 ">
		<div class="mt-4 mt-md-5 pt-4">
			<h4 class="mb-4 text-center">Select the Connection Type</h4>
			<div class="row">
				<div class="col-xl-4 rounded mx-auto">
					<div id="connection-type"
						class="row align-items-center justify-content-center">
						<div class="col-6 px-2 mb-2 mb-md-3">
							<a href="#" id="postpaid-btn">
								<div
									class="card card-active  px-2 py-4  text-center text-black ">
									<h6 role="heading" aria-level="5">Prepaid</h6>
								</div>
							</a>
						</div>
						<div class="col-6 px-2 mb-2 mb-md-3">
							<a href="#" id="prepaid-btn">
								<div class="card px-2 py-4 text-center text-black ">
									<h6>Postpaid</h6>
								</div>
							</a>
						</div>
					</div>
				</div>
			</div>
			<div class="mt-3 mt-md-4 text-center">
				<h4 class="mb-2">Select A Plan To Update</h4>
				<p class="type-1 off-grey-color mb-2">You can upgrade or
					downgrade your plan later</p>
			</div>
		</div>


		<%
		int id = Integer.parseInt(request.getParameter("id"));
		PckImpl pck = new PckImpl(DBconnect.getcon());

		Package p = pck.getPckById(id);
		  if (p == null) {
		      //redirect to an error page or show a message
		        out.println("<div class='alert alert-danger'>Package not found!</div>");
		        return; // Prevents the rest of the code from executing
		    }
		
		%>

		<div class="container-fluid pt-2 pb-2">
			<div class="row justify-content-center">
				<div class="rounded col-mr-4">




					<form action="${pageContext.request.contextPath}/PckEdit"
						method="post" class=" rounded border col-xl-12 p-3"
						style="width: 400px;">
						<div class="form-group">

							<input type="hidden" name="id" value=<%=p.getPckid()%>>

							<label for="fullName">Full Name</label> <input type="text"
								name="username" class="form-control" id="fullName"
								placeholder="Enter your full name" value=<%=p.getFull_name()%>required>
						</div>
						<div class="form-group">
							<label for="phoneNumber">Phone Number</label> <input
								type="number" name="number" class="form-control"
								id="phoneNumber" placeholder="Enter your phone number" value=<%=p.getNum()%> required>
						</div>

						<div class="form-group">
							<label for="packageSelection">Select Package</label> <select
								name="pcktype" class="form-control" id="packageSelection"
								required>
								<option value="" disabled selected>Select a package...</option>
								<option value="data">Data Only</option>
								<option value="talk-text">Talk & Text</option>
								<option value="combo">Combo (Data + Talk & Text)</option>
							</select>
						</div>

						<div class="form-group">
							<label for="durationSelection">Select Duration</label> <select
								name="duration" class="form-control" id="durationSelection"
								onchange="showPrice()" required>
								<option value="" disabled selected>Select a duration...</option>
								<option value="7">7 days</option>
								<option value="14">14 days</option>
								<option value="30">30 days</option>
							</select>
						</div>

						<div class="form-group">
							<label for="priceDisplay">Price</label> <input type="text"
								id="priceDisplay" class="form-control" name="data-allowance"
								value="Select a package to see the price" readonly>
						</div>


						<div class="form-group">
							<label for="paymentMethod">Payment Method</label> <select
								class="form-control" id="paymentMethod" name="pMethod" required>
								<option value="" disabled selected>Select a payment
									method...</option>
								<option value="card">Credit/Debit Card</option>
								<option value="wallet">Mobile Wallet</option>
								<option value="bank">Bank Transfer</option>
								<option value="balance">Prepaid Balance</option>
							</select>
						</div>



						<div class="form-group form-check">
							<input type="checkbox" name="agreed" class="form-check-input"
								id="termsCheck" required> <label
								class="form-check-label" for="termsCheck">I agree to the
								<a href="#">Terms & Conditions</a>
							</label>
						</div>
						<div class="text-center">
							<button type="submit" class="btn btn-primary col-xl-6">Activate
								Package</button>
						</div>
					</form>


				</div>
			</div>





		</div>

	</div>




	<script>
		document
				.addEventListener(
						"DOMContentLoaded",
						function() {
							function showPrice() {
								const packageSelection = document
										.getElementById("packageSelection").value;
								const durationSelection = document
										.getElementById("durationSelection").value;
								const priceDisplay = document
										.getElementById("priceDisplay");

								// Set prices in Rs based on package and duration
								if (packageSelection === "data"
										&& durationSelection === "7") {
									priceDisplay.value = "Rs 500";
								} else if (packageSelection === "data"
										&& durationSelection === "14") {
									priceDisplay.value = "Rs 900";
								} else if (packageSelection === "data"
										&& durationSelection === "30") {
									priceDisplay.value = "Rs 1500";
								} else if (packageSelection === "talk-text"
										&& durationSelection === "7") {
									priceDisplay.value = "Rs 400";
								} else if (packageSelection === "talk-text"
										&& durationSelection === "14") {
									priceDisplay.value = "Rs 700 ";
								} else if (packageSelection === "talk-text"
										&& durationSelection === "30") {
									priceDisplay.value = "Rs 1200 ";
								} else if (packageSelection === "combo"
										&& durationSelection === "7") {
									priceDisplay.value = "Rs 800)";
								} else if (packageSelection === "combo"
										&& durationSelection === "14") {
									priceDisplay.value = "Rs 1500)";
								} else if (packageSelection === "combo"
										&& durationSelection === "30") {
									priceDisplay.value = "Rs 2500";
								} else {
									priceDisplay.value = "Select a package and duration to see the price";
								}
							}

							document.getElementById("packageSelection")
									.addEventListener("change", showPrice);
							document.getElementById("durationSelection")
									.addEventListener("change", showPrice);
						});
	</script>



	<%@include file="/allcomponents/footer.jsp"%>
</body>
</html>