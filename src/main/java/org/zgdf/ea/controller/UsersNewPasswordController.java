package org.zgdf.ea.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.zgdf.ea.db.UsersDao;
import org.zgdf.ea.utils.HashPassword;
//import javax.servlet.http.HttpSession;

public class UsersNewPasswordController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sUser = request.getParameter("selectedUser");
        String newPW = request.getParameter("newpass");
        String hashedPW = HashPassword.hashedPW(newPW);
        
        UsersDao dao = new UsersDao();
        //HttpSession session = request.getSession();
        dao.modifyPassword(sUser, hashedPW);
        
        //System.out.println(sUser + " " + newPW);
        
        response.sendRedirect("UsersListController");
        
    }

}
