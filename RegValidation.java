package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegValidation
 */
public class RegValidation extends HttpServlet {
    public RegValidation() {
    }

    public void service(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String accno = req.getParameter("accno");
            String name = req.getParameter("name");
            String pass = req.getParameter("pass");
            String email = req.getParameter("email");
            String balance = req.getParameter("balance");
            if (accno.length() != 0 && name.length() != 0 && pass.length() != 0 && email.length() != 0 && balance.length() != 0) {
                req.getServletContext().getRequestDispatcher("/Register").forward(req, resp);
            } else {
                resp.sendRedirect("/BankApplication/invalidreg.html");
            }
        } catch (Exception var8) {
            var8.printStackTrace();
        }

    }
}
