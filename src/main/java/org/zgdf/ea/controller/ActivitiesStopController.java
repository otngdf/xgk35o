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

public class ActivitiesStopController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        int uid = (Integer) session.getAttribute("userid");
        
        ActivitiesDao dao = new ActivitiesDao();
        List<Activities> listActivities = dao.listWhatHasNoEnd(uid);
        
        request.setAttribute("listActivities", listActivities);
        
        request.getRequestDispatcher("stop.jsp").forward(request, response);

    }

}