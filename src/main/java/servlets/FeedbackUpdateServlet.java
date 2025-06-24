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


@WebServlet("/UpdateFeedback")
public class FeedbackUpdateServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		try {
		
			
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String rate = req.getParameter("rating");
			String feedback = req.getParameter("feed");
			
			
			Feedback fb = new Feedback();
			
			fb.setFeedbackid(id);
			fb.setName(name);
			fb.setEmail(email);
			fb.setRate(rate);
			fb.setFeedback(feedback);
			
			FeedbackDbcImpl fbi = new FeedbackDbcImpl();
	
			
			boolean f = fbi.FeedbackEdit(fb);
			
			HttpSession session = req.getSession();
			
			
			if (f) {

				session.setAttribute("succsmsg", "Feedback Updated sucessfull");
				resp.sendRedirect("UserProfile.jsp");

			} else {
				session.setAttribute("failedmsg", "Feedback Updated Unsucessfull");
				resp.sendRedirect("Feedback.jsp");
			}
			

			
		} catch (Exception e) {
			
			
			e.printStackTrace();
			
		}


	}
	
	
	
	
	

}
