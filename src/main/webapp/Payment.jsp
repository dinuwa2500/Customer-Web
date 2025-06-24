
<%@include file = "allcomponents/allcss.jsp" %>
<%@include file = "allcomponents/header.jsp"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Make a Payment</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            margin-top: 50px;
        }
        .payment-form {
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .btn-success {
            background-color: #28a745;
            border-color: #28a745;
        }
        .btn-success:hover {
            background-color: #218838;
            border-color: #1e7e34;
        }
    </style>
</head>
<body>

<div class="container pt-5 mb-5 ">
    <h2 class="text-center mb-4">Make a Payment</h2>
    <div class="row justify-content-center">
        <div class="col-md-6 payment-form">
            <form action = "pay" method = "post">
                <div class="form-group">
                    <label for="card-number">Card Number</label>
                    <input type="text" class="form-control" id="card-number" placeholder="1234 5678 9123 4567" name ="cardnum" required>
                </div>
                <div class="form-group">
                    <label for="name-on-card">Name on Card</label>
                    <input type="text" class="form-control" id="name-on-card" placeholder="Full Name" name = "cardname" required>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="expiry-date">Expiry Date</label>
                        <input type="text" class="form-control" id="expiry-date" placeholder="MM/YY" name = "expirydate" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="cvv">CVV</label>
                        <input type="text" class="form-control" id="cvv" placeholder="123" name = "cvv" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="amount">Payment Amount</label>
                    <input type="text" class="form-control" id="amount" placeholder="Amount" name = "amount" required>
                </div>
                <button type="submit" class="btn btn-success btn-block">Pay Now</button>
            </form>
        </div>
    </div>
</div>
    
<%@include file = "allcomponents/footer.jsp" %>
</body>
</html>