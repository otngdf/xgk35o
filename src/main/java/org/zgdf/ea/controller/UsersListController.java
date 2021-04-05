package org.zgdf.ea.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.zgdf.ea.db.UsersDao;
import org.zgdf.ea.model.Users;

public class UsersListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UsersDao dao = new UsersDao();

        List<Users> listUsers = dao.list();

        request.setAttribute("listUsers", listUsers);

        request.getRequestDispatcher("a_users.jsp").forward(request, response);
    }

}
