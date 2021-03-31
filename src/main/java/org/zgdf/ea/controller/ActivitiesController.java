package org.zgdf.ea.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.zgdf.ea.db.ActivitiesDao;

public class ActivitiesController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String date = request.getParameter("date");
        int customer = Integer.parseInt(request.getParameter("customer"));
        String activity = request.getParameter("activity");
        int userid = (Integer) session.getAttribute("userid");

        ActivitiesDao dao = new ActivitiesDao();

        if (dao.hasNoEnd(userid)) {
//            response.sendRedirect("stop.jsp");
            request.setAttribute("vanbefejezetlen", "Van nem lezárt munkád, addig nem rögzíthetsz újat!");
            RequestDispatcher rd = request.getRequestDispatcher("CustomersListController.do");
            rd.forward(request, response);
            
        } else {
            dao.insert(userid, customer, date, activity);

            response.sendRedirect("CustomersListController.do");
        }

    }

}
