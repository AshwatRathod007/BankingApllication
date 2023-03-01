package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Model;


public class ChangeName extends HttpServlet {
	
    public ChangeName() {
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String nn = req.getParameter("nn");
            String p = req.getParameter("p");
            HttpSession hs = req.getSession();
            int accno = (Integer)hs.getAttribute("accno");
            Model m = new Model();
            m.setAccno(accno);
            m.setName(nn);
            m.setPass(p);
            boolean status = m.changeName();
            if (status) {
                resp.sendRedirect("/BankApplication/changenamesuccess.html");
            } else {
                resp.sendRedirect("/BankApplication/changenamefail.html");
            }
        } catch (Exception var9) {
            var9.printStackTrace();
        }

    }
    }
