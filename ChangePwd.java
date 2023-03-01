package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Model;

/**
 * Servlet implementation class ChangePwd
 */
public class ChangePwd extends HttpServlet {
    public ChangePwd() {
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String op = req.getParameter("op");
            String np = req.getParameter("np");
            HttpSession hs = req.getSession();
            int accno = (Integer)hs.getAttribute("accno");
            Model m = new Model();
            m.setAccno(accno);
            m.setPass(op);
            boolean status = m.changePwd(np);
            if (status) {
                resp.sendRedirect("/BankApplication/changepwdsuccess.html");
            } else {
                resp.sendRedirect("/BankApplication/changepwdfail.html");
            }
        } catch (Exception var9) {
            var9.printStackTrace();
        }

    }
}
