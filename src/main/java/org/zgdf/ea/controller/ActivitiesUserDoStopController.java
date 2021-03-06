package org.zgdf.ea.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.zgdf.ea.db.ActivitiesDao;

public class ActivitiesUserDoStopController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        String date = request.getParameter("date");
        int userid = (Integer) session.getAttribute("userid");

        ActivitiesDao dao = new ActivitiesDao();

        dao.updateStop(userid, date);

        response.sendRedirect("u_stop.jsp");
    }

}
