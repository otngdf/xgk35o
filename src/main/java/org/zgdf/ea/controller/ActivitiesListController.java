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
import org.zgdf.ea.utils.GetLogMessage;

public class ActivitiesListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ActivitiesDao dao = new ActivitiesDao();
        List<Activities> listActivities = dao.list();

        request.setAttribute("listActivities", listActivities);

        HttpSession session = request.getSession();
        String loggedinuser = session.getAttribute("user").toString();
        
        System.out.println(GetLogMessage.message() + "Tevekenyseg lekerdezes: " + loggedinuser);
        
        request.getRequestDispatcher("a_activities.jsp").forward(request, response);

    }

}
