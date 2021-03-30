package org.zgdf.ea.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import org.zgdf.ea.db.UsersDao;

public class UsersActivateInactivateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        HttpSession session = request.getSession();
//        
//        System.out.println(session.getAttribute("user"));
//        System.out.println(request.getParameter("did"));
//        System.out.println(request.getParameter("dactive"));
        int mid = Integer.parseInt(request.getParameter("mid"));
        int mactive = Integer.parseInt(request.getParameter("mactive"));

//        System.out.println(drole + " " + did);
        if (mactive == 1) {
            mactive = 0;
        } else {
            mactive = 1;
        }

        //System.out.println(mid + " " + mactive);

        UsersDao dao = new UsersDao();

        dao.activateInactivate(mid, mactive);

        response.sendRedirect("UsersListController");

    }

}
