package org.zgdf.ea.controller;

import org.zgdf.ea.utils.GetLogMessage;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.zgdf.ea.model.Customers;
import org.zgdf.ea.db.CustomersDao;
import org.zgdf.ea.utils.HashPassword;

public class LoginCustomersController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("uname");
        String password = request.getParameter("pwd");
        String hashedPW = HashPassword.hashedPW(password);

        CustomersDao dao = new CustomersDao();
        Customers c = dao.getCustomer(username, hashedPW);

        HttpSession session = request.getSession();

        if (c.getcUser() != null) {

            session.setAttribute("id", c.getCustomerID());
            session.setAttribute("name", c.getcName());
            session.setAttribute("user", c.getcUser());
            System.out.println(GetLogMessage.message() + "Sikeres customer login: " + username);

            response.sendRedirect("c_home.jsp");
        } else {
            System.out.println(GetLogMessage.message() + "Sikertelen customer login: " + username);
            session.setAttribute("hibasuser", "Nem megfelelő felhasználónév vagy jelszó!");
            response.sendRedirect("c_login.jsp");
        }

    }

}
