package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbc.PaymentDbcImpl;
import entity.User;

@WebServlet("/pay")
public class PaymentInsertServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		boolean isTrue = false;
		PaymentDbcImpl paydao = new PaymentDbcImpl();
		HttpSession session = req.getSession();
		User us = (User) session.getAttribute("userobj"); // Get the user from the session

		/*
		 * // Check if the user is logged in if (us == null) {
		 * resp.sendRedirect("login.jsp"); return; }
		 */
	
		
		try {

			if(us == null) {
				
				
				resp.sendRedirect("login.jsp");
				
			}
			
			int User_id = us.getId();
			String cardnumber = req.getParameter("cardnum");
			String  cardowner = req.getParameter("cardname");
			String expDate = req.getParameter("expirydate");
			String cvv = req.getParameter("cvv");
			String amount = req.getParameter("amount");
			
			
			isTrue = paydao.addPayment(User_id, cardowner, cardnumber, expDate, cvv,amount);
		
				
				if(isTrue == true) {
				
				session.setAttribute("succMsg", "Sucessfully Activated  Package");
				resp.sendRedirect("UserProfile.jsp");

			} else {

				System.out.println("something wrong");
				session.setAttribute("failedMsg", "Something Wrong");
				resp.sendRedirect("Payment.jsp");

			}
			
		
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
