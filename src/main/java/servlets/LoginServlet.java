package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBconnect;
import dbc.AdminDbcImpl;
import dbc.UserdbcImpl;
import entity.User;

@SuppressWarnings("serial")
@WebServlet("/login")

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Connection con;
		int userId;
		try {

			con = DBconnect.getcon();

			UserdbcImpl dao = new UserdbcImpl();
			AdminDbcImpl adao = new AdminDbcImpl();
			
			
			HttpSession session = req.getSession();

			String email = req.getParameter("email");
			String password = req.getParameter("password");

			if ("admin@gmail.com".equals(email) && "admin".equals(password)) {

				User us = dao.UserLogin(email, password);
				userId = us.getId();

				//System.out.println(userId);
			
				adao.incrementVisitCount(userId);
				session.setAttribute("userobj", us);
				session.setAttribute("userEmail", us.getEmail());
				session.setAttribute("userId", userId);
				resp.sendRedirect("Admin/AdminDashboard.jsp");

			} else if ("Techsup@gmail.com".equals(email) && "techsup".equals(password)) {

				User us = dao.UserLogin(email, password);
				userId = us.getId();

				//System.out.println(userId);
				adao.incrementVisitCount(userId);
				session.setAttribute("userobj", us);
				session.setAttribute("userEmail", us.getEmail());
				session.setAttribute("userId", userId);
				resp.sendRedirect("Admin/Techsupport/AdminDashboard.jsp");

			} else if ("Billingsup@gmail.com".equals(email) && "billingsup".equals(password)) {

				User us = dao.UserLogin(email, password);
				userId = us.getId();

				System.out.println(userId);
				adao.incrementVisitCount(userId);
				session.setAttribute("userobj", us);
				session.setAttribute("userEmail", us.getEmail());
				session.setAttribute("userId", userId);
				resp.sendRedirect("Admin/Billingsup/AdminDashboard.jsp");

			} else {

				User us = dao.UserLogin(email, password);

				if (us != null) {

					// System.out.println("sucess");
					userId = us.getId();

					System.out.println(userId);
					adao.incrementVisitCount(userId);
					session.setAttribute("userobj", us);
					session.setAttribute("userId", userId);
					resp.sendRedirect("UserProfile.jsp");

				} else {

					session.setAttribute("failedmsg", "Email Or Password invalid");
					resp.sendRedirect("login.jsp");

				}

				
				int totalVisits = adao.getTotalVisits();
	            session.setAttribute("totalVisits", totalVisits);
				

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
	


	
	
	

}
