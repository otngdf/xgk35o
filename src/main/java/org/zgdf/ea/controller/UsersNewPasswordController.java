package org.zgdf.ea.controller;

import java.io.IOException;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.zgdf.ea.db.UsersDao;
import org.zgdf.ea.utils.HashPassword;

public class UsersNewPasswordController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sUser = request.getParameter("selectedUser");
        String newPW = request.getParameter("newpass");
        String hashedPW = HashPassword.hashedPW(newPW);
        
        UsersDao dao = new UsersDao();
        HttpSession session = request.getSession(false);
        dao.modifyPassword(sUser, hashedPW);
        
        //System.out.println(sUser + " " + newPW);
        
        //request.setAttribute("modositva", "A jelszó módosítva!");
        //RequestDispatcher rd = request.getRequestDispatcher("UsersListController");
        //rd.forward(request, response);
        
        session.setAttribute("modositva", "A jelszó módosítva az alábbi felhasználónál: " + sUser);
        response.sendRedirect("UsersListController.do");
        
    }

}
