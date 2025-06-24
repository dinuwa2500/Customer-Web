package servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBconnect;
import dbc.PaymentDbcImpl;



@WebServlet("/deletePayment")
public class DeletePayServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			Connection con = DBconnect.getcon();
			
			PaymentDbcImpl pay = new PaymentDbcImpl();
			
			
			int id = Integer.parseInt(req.getParameter("id"));
			
			
			boolean f = pay.deletePayment(id);
			
			HttpSession session = req.getSession();

			if (f) {

				session.setAttribute("succsmsg", "Payment Deleted Sucessfull");
				resp.sendRedirect("Admin/Billingsup/AdminDashboard.jsp");

			} else {
				session.setAttribute("failedmsg", "Payment Deleted UnSucessfull");
				resp.sendRedirect("Payment.jsp");
			}


		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
