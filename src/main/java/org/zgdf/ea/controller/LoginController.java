package org.zgdf.ea.controller;

import org.zgdf.ea.utils.GetLogMessage;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.zgdf.ea.model.Users;
import org.zgdf.ea.db.UsersDao;
import org.zgdf.ea.db.VersionDao;
import org.zgdf.ea.utils.HashPassword;

public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("uname");
        String password = request.getParameter("pwd");
        String hashedPW = HashPassword.hashedPW(password);

        UsersDao dao = new UsersDao();
        Users u = dao.getUser(username, hashedPW);

        VersionDao daov = new VersionDao();
        String v = daov.showVersion();
//        System.out.println(v);

        HttpSession session = request.getSession();

        if (u.getUserName() != null && u.getUserRole().equals("user")) {
//            request.setAttribute("user", u);

            session.setAttribute("userid", u.getUserID());
            session.setAttribute("user", u.getUserName());
            session.setAttribute("role", u.getUserRole());
            session.setAttribute("fullname", u.getFullName());
            session.setAttribute("verzio", v);
            System.out.println(GetLogMessage.message() + "Sikeres login: " + username);

//            RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
//            rd.forward(request, response);
            response.sendRedirect("u_home.jsp");
        } else if (u.getUserName() != null && u.getUserRole().equals("admin")) {
            session.setAttribute("userid", u.getUserID());
            session.setAttribute("user", u.getUserName());
            session.setAttribute("role", u.getUserRole());
            session.setAttribute("fullname", u.getFullName());
            session.setAttribute("verzio", v);
            System.out.println(GetLogMessage.message() + "Sikeres login: " + username);

            response.sendRedirect("a_home.jsp");
        } else {
//            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//            rd.forward(request, response);
            System.out.println(GetLogMessage.message() + "Sikertelen login: " + username);
            session.setAttribute("hibasuser", "Nem megfelelő felhasználónév vagy jelszó!");
            response.sendRedirect("login.jsp");
        }

    }

}
