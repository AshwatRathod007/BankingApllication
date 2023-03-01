package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForgotPwdVal
 */
public class ForgotPwdVal extends HttpServlet {
	 public ForgotPwdVal() {
	    }

	    protected void service(HttpServletRequest req, HttpServletResponse resp) {
	        try {
	            String accno = req.getParameter("accno");
	            String name = req.getParameter("name");
	            String email = req.getParameter("email");
	            String np = req.getParameter("np");
	            String cnp = req.getParameter("cnp");
	            if (accno.length() != 0 && name.length() != 0 && email.length() != 0 && np.length() != 0 && cnp.length() != 0) {
	                if (np.equals(cnp)) {
	                    req.getServletContext().getRequestDispatcher("/ForgotPwd").forward(req, resp);
	                } else {
	                    resp.sendRedirect("/BankApplication/forgotpwderror.html");
	                }
	            } else {
	                resp.sendRedirect("/BankApplication/forgotpwderror.html");
	            }
	        } catch (Exception var8) {
	            var8.printStackTrace();
	        }

	    }

}
