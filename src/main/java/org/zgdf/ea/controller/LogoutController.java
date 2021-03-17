package org.zgdf.ea.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        HttpSession session = request.getSession();
        
        String username = session.getAttribute("user").toString();
        System.out.println(GetLogMessage.message() + "Sikeres logout: " + username);
        
        session.removeAttribute("userid");
        session.removeAttribute("user");
        session.removeAttribute("role");
        session.removeAttribute("fullname");
        session.invalidate();
        
        response.sendRedirect("index.jsp");
        
    }

}
