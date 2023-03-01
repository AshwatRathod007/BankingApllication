package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Model;

/**
 * Servlet implementation class ForgotPwd
 */
public class ForgotPwd extends HttpServlet {
	 public ForgotPwd() {
	    }

	    protected void service(HttpServletRequest req, HttpServletResponse resp) {
	        try {
	            int accno = Integer.parseInt(req.getParameter("accno"));
	            String name = req.getParameter("name");
	            String email = req.getParameter("email");
	            String np = req.getParameter("np");
	            Model m = new Model();
	            m.setAccno(accno);
	            m.setName(name);
	            m.setEmail(email);
	            boolean status = m.forgotPassword(np);
	            if (status==true) {
	                resp.sendRedirect("/BankApplication/forgotpwdsuccess.html");
	            } else {
	                resp.sendRedirect("/BankApplication/forgotpwdfail.html");
	            }
	        } catch (Exception var9) {
	            var9.printStackTrace();
	        }

	    }
}
