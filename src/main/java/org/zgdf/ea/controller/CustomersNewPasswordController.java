package org.zgdf.ea.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.zgdf.ea.db.CustomersDao;
import org.zgdf.ea.utils.HashPassword;

public class CustomersNewPasswordController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sUser = request.getParameter("selectedUser");
        String newPW = request.getParameter("newpass");
        String hashedPW = HashPassword.hashedPW(newPW);

        CustomersDao dao = new CustomersDao();
        HttpSession session = request.getSession(false);
        dao.modifyPassword(sUser, hashedPW);

        session.setAttribute("modositva", "A jelszó módosítva az alábbi felhasználónál: " + sUser);
        response.sendRedirect("CustomersListController.do");

    }

}
