package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBconnect;
import dbc.PckImpl;



@WebServlet("/delete")
public class DeletePckServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			
		int id = Integer.parseInt(req.getParameter("id"));
		
		
		try {
		PckImpl pck = new PckImpl(DBconnect.getcon());
		
		boolean f = pck.deletePck(id);
		
		
		HttpSession session = req.getSession();

		if (f) {

			session.setAttribute("succsmsg", "Package Deleted sucessfull");
			resp.sendRedirect("UserProfile.jsp");

		} else {
			session.setAttribute("failedmsg", "Package Deleted Unsucessfull");
			resp.sendRedirect("UserProfile.jsp");
		}

		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
