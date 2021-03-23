package org.zgdf.ea.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.zgdf.ea.db.UsersDao;
import org.zgdf.ea.utils.HashPassword;

public class ModifyMyPasswordController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String newPW = request.getParameter("newpass");
        String hashedPW = HashPassword.hashedPW(newPW);
        
        UsersDao dao = new UsersDao();
        HttpSession session = request.getSession();
        String sUser = (String) session.getAttribute("user");
        
        dao.modifyPassword(sUser, hashedPW);
        
      
        session.setAttribute("modositva", "A jelszó módosítva!");
        response.sendRedirect("home.jsp");
        
    }

}
