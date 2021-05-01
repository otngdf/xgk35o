package org.zgdf.ea.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.zgdf.ea.db.UsersDao;
import org.zgdf.ea.utils.HashPassword;

public class UsersCreateController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //request.setCharacterEncoding("UTF-8");
        String uname = request.getParameter("uname");
        String upass = request.getParameter("upass");
        String urole = request.getParameter("urole");
        String ufullname = request.getParameter("ufullname");
        String hashedPW = HashPassword.hashedPW(upass);

        //System.out.println(ufullname);
        UsersDao dao = new UsersDao();

        dao.insert(uname, hashedPW, urole, ufullname);

        response.sendRedirect("UsersListController.do");

    }

}
