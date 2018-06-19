package org.zgdf.ea.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.zgdf.ea.model.Users;
import org.zgdf.ea.db.UsersDao;

public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("uname");
        String password = request.getParameter("pwd");

        UsersDao dao = new UsersDao();
        Users u = dao.getUser(username, password);

        HttpSession session = request.getSession();

        if (u.getUserName() != null) {
//            request.setAttribute("user", u);

            session.setAttribute("userid", u.getUserID());
            session.setAttribute("user", u.getUserName());
            session.setAttribute("role", u.getUserRole());
            session.setAttribute("fullname", u.getFullName());

//            RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
//            rd.forward(request, response);
            response.sendRedirect("home.jsp");
        } else {
//            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//            rd.forward(request, response);
            session.setAttribute("hibasuser", "Nem megfelelő felhasználónév vagy jelszó!");
            response.sendRedirect("index.jsp");
        }

    }

}
