package servlets;


/*
 * package servlets;
 * 
 * import java.io.IOException; import java.lang.System.Logger;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * import db.DBconnect; import dbc.UserdbcImpl; import entity.User;
 * 
 * @SuppressWarnings("serial")
 * 
 * @WebServlet("/Register")
 * 
 * public class RegisterServlet extends HttpServlet {
 * 
 * private int i; // private static final Logger logger = //
 * Logger.getLogger(RegisterServlet.class.getName());
 * 
 * @Override protected void doPost(HttpServletRequest req, HttpServletResponse
 * resp) throws ServletException, IOException {
 * 
 * try {
 * 
 * String Fname = req.getParameter("name"); String Lname =
 * req.getParameter("lname"); String Email = req.getParameter("email"); String
 * Password = req.getParameter("password"); String Phno =
 * req.getParameter("number"); String Checkbox = req.getParameter("remember");
 * 
 * User us = new User(); us.setFname(Fname); us.setLname(Lname);
 * us.setEmail(Email); us.setPassword(Password); us.setPhno(Phno);
 * 
 * HttpSession session = req.getSession();
 * 
 * if (Checkbox != null) {
 * 
 * UserdbcImpl usdao = new UserdbcImpl(DBconnect.getcon());
 * 
 * boolean f = usdao.UserRegister(us);
 * 
 * if (f) {
 * 
 * //System.out.println("user register sucessful");
 * 
 * session.setAttribute("succesmsg", "Register Sucessful");
 * resp.sendRedirect("Register.jsp");
 * 
 * } else {
 * 
 * // System.out.println("Something Went Wrong");
 * session.setAttribute("failedmsg", "Something Went Wrong");
 * resp.sendRedirect("Register.jsp");
 * 
 * }
 * 
 * } else {
 * 
 * // System.out.println("Please Check Agreement ");
 * session.setAttribute("failedmsg", "Please Check Agreement");
 * resp.sendRedirect("Register.jsp"); } } catch (Exception e) {
 * 
 * // logger.severe("Data insertion failed: " + e.getMessage());
 * e.printStackTrace();
 * 
 * }
 * 
 * }
 * 
 * }
 */

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dbc.UserdbcImpl;

@SuppressWarnings("serial")

@WebServlet("/Register")

public class RegisterServlet extends HttpServlet {
	

	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		UserdbcImpl dao = new UserdbcImpl();
		
		String Fname = req.getParameter("name");
		String Lname = req.getParameter("lname");
		String Email = req.getParameter("email");
		String Password = req.getParameter("password");
		String Phno = req.getParameter("number");
		String Checkbox = req.getParameter("remember");
		
		
		boolean isTrue;
		
		isTrue = dao.insertData(Fname, Lname, Email, Phno, Password);
		
		if(isTrue ==true) {
			RequestDispatcher dis2 = req.getRequestDispatcher("login.jsp");
			dis2.forward(req, resp);
		}
		else {
			RequestDispatcher dis2 = req.getRequestDispatcher("wrong.jsp");
			dis2.forward(req, resp);
		}
		
	}

}
