package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginValidation
 */
public class LoginValidation extends HttpServlet {
	public LoginValidation() {
	}

	protected void service(HttpServletRequest req, HttpServletResponse resp) {
	    try {
			String accno =req.getParameter("accno");
			String pass = req.getParameter("pass");
			System.out.println(accno);
			System.out.println(pass);
			if (accno.length()==4   &&  pass.length() !=0) {
				req.getServletContext().getRequestDispatcher("/Login").forward(req, resp);
			} else {
				resp.sendRedirect("/BankApplication/invalidlogin.html");
			}
		} catch (Exception var5) {
			var5.printStackTrace();
		}

	}

}
