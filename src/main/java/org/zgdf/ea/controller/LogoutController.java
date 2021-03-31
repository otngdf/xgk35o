package org.zgdf.ea.controller;

import org.zgdf.ea.utils.GetLogMessage;
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

//        if (request.getSession(false) == null) {
//            System.out.println(GetLogMessage.message() + "Lejart session");
//            response.sendRedirect("index.jsp");
//        } else {

            HttpSession session = request.getSession(false);

            String username = session.getAttribute("user").toString();

//        session.removeAttribute("userid");
//        session.removeAttribute("user");
//        session.removeAttribute("role");
//        session.removeAttribute("fullname");
            session.invalidate();

            System.out.println(GetLogMessage.message() + "Sikeres logout: " + username);

            response.sendRedirect("index.jsp");
        }
//    }

}
