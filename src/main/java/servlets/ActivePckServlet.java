package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBconnect;
import dbc.PckImpl;
import entity.User;
import entity.Package;

import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet("/PckActive")

public class ActivePckServlet extends HttpServlet {

	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			HttpSession session = req.getSession();
            User us = (User) session.getAttribute("userobj"); // Get the user from the session

            // Check if the user is logged in
            if (us == null) {
                resp.sendRedirect("login.jsp");
                return;
            }
            
            
        	String checkbox = req.getParameter("checkbox");
            
			/*
			 * if (checkbox != null) { session.setAttribute("failedmsg",
			 * "Please check the agreement."); resp.sendRedirect("Prepaid.jsp"); return; }
			 */
        	
			int User_id = us.getId();
			String username = req.getParameter("username");
			String ph_no = req.getParameter("number");
			String pcktype = req.getParameter("pcktype");
			String duration = req.getParameter("duration");
			String price = req.getParameter("data-allowance");
			String pMethod = req.getParameter("pMethod");
		

			Package p = new Package(User_id, username, pcktype, ph_no, duration, price, pMethod);

			PckImpl pci = new PckImpl(DBconnect.getcon());

			boolean f = pci.AddPck(p);

			
	
			if (f) {
					
				

				session.setAttribute("succMsg", "Sucessfully Activated  Package");
				resp.sendRedirect("Payment.jsp");

			} else {

				System.out.println("something wrong");
				session.setAttribute("failedMsg", "Something Wrong");
				resp.sendRedirect("./Mobile/Prepaid.jsp");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
