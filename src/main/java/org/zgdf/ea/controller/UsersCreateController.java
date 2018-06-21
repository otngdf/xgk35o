package org.zgdf.ea.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.zgdf.ea.db.UsersDao;

public class UsersCreateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String uname = request.getParameter("uname");
        String upass = request.getParameter("upass");
        String urole = request.getParameter("urole");
        String ufullname = request.getParameter("ufullname");

        UsersDao dao = new UsersDao();

        dao.insert(uname, upass, urole, ufullname);

        response.sendRedirect("UsersListController");
        
    }

}
