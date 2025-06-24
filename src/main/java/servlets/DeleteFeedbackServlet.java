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
import dbc.FeedbackDbcImpl;
import entity.Feedback;


@WebServlet("/DeleteFeedback")
public class DeleteFeedbackServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		try {
			
			FeedbackDbcImpl fdao = new FeedbackDbcImpl();
			Connection con = DBconnect.getcon();
			
			int id = Integer.parseInt(req.getParameter("id"));

			
			boolean f = fdao.DeleteFeedback(id);
			
			
			HttpSession session = req.getSession();

			if (f) {

				session.setAttribute("succsmsg", "Feedback Deleted sucessfull");
				resp.sendRedirect("UserProfile.jsp");

			} else {
				session.setAttribute("failedmsg", "Feedback Deleted Unsucessfull");
				resp.sendRedirect("Feedback.jsp");
			}
			
			
			
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	

}
