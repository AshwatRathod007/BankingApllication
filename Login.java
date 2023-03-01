package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Model;

public class Login extends HttpServlet {
	public Login() {
	}

	public void service(HttpServletRequest req, HttpServletResponse resp) {
		try {
			int accno=Integer.parseInt(req.getParameter("accno"));
			String pass = req.getParameter("pass");
			Model m = new Model();
			m.setAccno(accno);
			m.setPass(pass);
			boolean status = m.login();
			if (status==true) {
				int a = m.getAccno();
				String b = m.getName();
				String c = m.getPass();
				String d = m.getEmail();
				int e = m.getBalance();
				HttpSession hs = req.getSession();
				hs.setAttribute("accno", a);
				hs.setAttribute("name", b);
				hs.setAttribute("pass", c);
				hs.setAttribute("email", d);
				hs.setAttribute("balance", e);
				resp.sendRedirect("/BankApplication/welcome.jsp");
			} else {
				resp.sendRedirect("/BankApplication/incorrect.html");
			}
		} catch (Exception var13) {
			var13.printStackTrace();
		}

	}
}
