package org.zgdf.ea.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.zgdf.ea.model.Users;
import org.zgdf.ea.db.UsersDao;

public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        PrintWriter pw = response.getWriter();
//        pw.print("helló");
    String username = request.getParameter("uname");
    String password = request.getParameter("pwd");
    
    UsersDao dao = new UsersDao();
    Users u = dao.getUser(username, password);
    
    request.setAttribute("user", u);
    
    RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
    rd.forward(request, response);
    
    }

}
