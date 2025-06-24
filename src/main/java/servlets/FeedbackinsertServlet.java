package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbc.FeedbackDbcImpl;
import entity.User;

@WebServlet("/Feedback")
public class FeedbackinsertServlet extends HttpServlet {

	boolean Istrue = false;
	FeedbackDbcImpl fdao = new FeedbackDbcImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		User us = (User) session.getAttribute("userobj"); // Get the user from the session

		try {

			int User_id = us.getId();
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String rate = req.getParameter("rating");
			String feedback = req.getParameter("feed");

			Istrue = fdao.addFeedback(User_id, name, email, rate, feedback);

			if (Istrue == true) {

				session.setAttribute("succMsg", "Sucessfully Added Feedback");
				resp.sendRedirect("UserProfile.jsp");

			} else {

				System.out.println("something wrong");
				session.setAttribute("failedMsg", "Something Wrong");
				resp.sendRedirect("Feedback.jsp");

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
