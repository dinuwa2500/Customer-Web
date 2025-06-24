package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBconnect;
import dbc.PckImpl;
import entity.Package;



@WebServlet("/PckEdit")
public class EditPckServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		int id = Integer.parseInt(req.getParameter("id"));
		String username = req.getParameter("username");
		String ph_no = req.getParameter("number");
		String pcktype = req.getParameter("pcktype");
		String duration = req.getParameter("duration");
		String price = req.getParameter("data-allowance");
		String pMethod = req.getParameter("pMethod");
		
		
		Package pck = new Package();
		
		pck.setPckid(id);
		pck.setFull_name(username);
		pck.setPcktype(pcktype);
		pck.setNum(ph_no);
		pck.setDuration(duration);
		pck.setPrice(price);
		pck.setpMethod(pMethod);
		
		
		PckImpl pm = new PckImpl(DBconnect.getcon());
		
		
		boolean f = pm.updateEditPck(pck);
		
		HttpSession session = req.getSession();

		if (f) {

			session.setAttribute("succsmsg", "Package Updated Sucessfull");
			resp.sendRedirect("UserProfile.jsp");

		} else {
			session.setAttribute("failedmsg", "Package Updated Sucessfull");
			resp.sendRedirect("Edit/Prepaid.jsp");
		}

		
		
	}
	
	
	
	
	
	
	

}
