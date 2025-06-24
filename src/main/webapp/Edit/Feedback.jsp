<%@page import="entity.Feedback"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dbc.FeedbackDbcImpl"%>
<%@include file="/allcomponents/allcss.jsp"%>
<%@include file="/allcomponents/header.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<title>Feedback Form with Star Rating</title>
<style>
body {
	background-color: #f8f9fa;
	font-family: Arial, sans-serif;
}

.feedback-container {
	margin: 50px auto; /* Centering the container */
	padding: 30px;
	background: white;
	border-radius: 8px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
	max-width: 600px; /* Set max width for the form */
}

.star-rating {
	direction: rtl;
	display: inline-block;
	margin-bottom: 15px;
}

.star-rating input {
	display: none;
}

.star-rating label {
	font-size: 30px;
	color: #ddd;
	cursor: pointer;
}

.star-rating input:checked ~ label {
	color: #f39c12;
}

.star-rating label:hover, .star-rating label:hover ~ label {
	color: #f39c12;
}

.btn-submit {
	background-color: #007bff;
	border: none;
}

.btn-submit:hover {
	background-color: #0056b3;
	color: white;
}

h2 {
	text-align: center;
	margin-bottom: 30px;
	color: #343a40;
}

label {
	font-weight: bold;
}

textarea {
	resize: none;
}
</style>
</head>


<%
String idParam = request.getParameter("id");
if (idParam == null) {
	out.println("<div class='alert alert-danger'>Feedback ID not provided!</div>");
	return; // Prevent further processing if id is missing
}

int id;
try {
	id = Integer.parseInt(idParam);
} catch (NumberFormatException e) {
	out.println("<div class='alert alert-danger'>Invalid Feedback ID format!</div>");
	return; // Prevent further processing if parsing fails
}

FeedbackDbcImpl fbi = new FeedbackDbcImpl();
Feedback nfeedback = fbi.getFdById(id);

if (nfeedback == null) {
	out.println("<div class='alert alert-danger'>Feedback not found!</div>");
	return; // Prevent further processing if feedback is not found
}
%>
<body>



	<div class="container">
		<div class="feedback-container">
			<h2>Feedback Form</h2>

			<form action="UpdateFeedback" method="post">
				<div class="form-group">

					<input type="hidden" name="id" value="<%=nfeedback.getFeedbackid()%>">
					 <label for="name">Name</label>
					<input type="text" class="form-control w-75 mx-auto" name="name"
						id="name" placeholder="Enter your name"
						value="<%=nfeedback.getName()%>" required>
				</div>
				<div class="form-group">
					<label for="email">Email</label> <input type="email"
						class="form-control w-75 mx-auto" name="email" id="email"
						placeholder="Enter your email" value="<%=nfeedback.getEmail()%>"
						required>
				</div>
				<div class="form-group">
					<label>Rate Your Experience</label>
					<div class="star-rating">
						<input type="radio" id="star5" name="rating" value="5"> <label
							for="star5" class="fas fa-star"></label> <input type="radio"
							id="star4" name="rating" value="4"> <label for="star4"
							class="fas fa-star"></label> <input type="radio" id="star3"
							name="rating" value="3"> <label for="star3"
							class="fas fa-star"></label> <input type="radio" id="star2"
							name="rating" value="2"> <label for="star2"
							class="fas fa-star"></label> <input type="radio" id="star1"
							name="rating" value="1"> <label for="star1"
							class="fas fa-star"></label>
					</div>
				</div>
				<div class="form-group">
					<label for="feedback">Feedback</label>
					<textarea class="form-control w-75 mx-auto" name="feed"
						id="feedback" rows="4" placeholder="Your feedback here..."
						required><%=nfeedback.getFeedback()%></textarea>
				</div>
				<button type="submit" class="btn btn-submit btn-block w-50 mx-auto">Submit
					Feedback</button>
			</form>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

	<%@include file="/allcomponents/footer.jsp"%>
</body>
</html>
