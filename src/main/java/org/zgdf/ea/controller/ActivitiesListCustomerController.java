package org.zgdf.ea.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.zgdf.ea.db.ActivitiesDao;
import org.zgdf.ea.model.Activities;

public class ActivitiesListCustomerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        int cid = (Integer) session.getAttribute("id");
        String cuser = (String) session.getAttribute("user");

        ActivitiesDao dao = new ActivitiesDao();
        List<Activities> listActivities = dao.list(cid,cuser);

        request.setAttribute("listActivities", listActivities);

        request.getRequestDispatcher("c_activities.jsp").forward(request, response);

    }

}
