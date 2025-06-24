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
										role="heading" aria-level="3">Prepaid
										connections</h4>
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
									<h4 class="py-0 px-3 py-md-2 px-md-3 px-lg-4 txt">Postpaid connections</h4>
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


	<!-- card body 2 -->

	<div class="container-fluid bg-light pt-3 pt-lg-3 pb-4 mb-5" style="height: 410px;">
		<div class="row justify-content-center mt-lg-2">




			<div class="col-12 col-sm-6 col-md-6 col-lg-3 col-xl-3 mb-3">
				<div class="card text-center">
					<div class="card-body pt-lg-2  pl-md-0 pr-md-0 pt-4 pb-lg-0">
						<h3 class="mb-2 mb-md-3">
							Get A<br role="presentation" data-uw-rm-sr=""> New
							Connection
						</h3>

						<a class="btn btn-link" href="/buy/new-connection/gsm"
							aria-label="Learn More Get ANew Connection">Learn
							More</a> 
						<img src="https://s3.ap-southeast-1.amazonaws.com/dlg.dialog.lk/s3fs-public/2023-04/mobile-new-connection.jpg"class=" img-fluid " alt="Card image cap">

					</div>
				</div>
			</div>

			<div class="col-12 col-sm-6 col-md-6 col-lg-3 col-xl-3 mb-3">
				<div class="card text-center">
					<div class="card-body pt-lg-2  pl-md-0 pr-md-0 pt-4 pb-lg-0">



						<h3 class="mb-2 mb-md-3">
							Get A<br role="presentation" data-uw-rm-sr=""> New
							Connection
						</h3>

						<a class="btn btn-link" href="/buy/new-connection/gsm"
							aria-label="Learn More Get ANew Connection">Learn
							More</a> 
						<img src="https://s3.ap-southeast-1.amazonaws.com/dlg.dialog.lk/s3fs-public/2023-04/mobile-new-connection.jpg"class=" img-fluid " alt="Card image cap">



					</div>
				</div>
			</div>

			<!-- card body 2 -->


		</div>
	</div>







	<%@include file="/allcomponents/footer.jsp"%>
</body>
</html>