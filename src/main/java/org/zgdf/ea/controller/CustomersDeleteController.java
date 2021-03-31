package org.zgdf.ea.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.zgdf.ea.db.CustomersDao;

public class CustomersDeleteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //System.out.println(request.getParameter("id"));
        int id = Integer.parseInt(request.getParameter("id"));

        CustomersDao dao = new CustomersDao();

        if (dao.hasActivity(id)) {
            request.setAttribute("vanmunka", "Az ügyfélhez tartozik munka, ezért nem törölhető!");
            RequestDispatcher rd = request.getRequestDispatcher("CustomersListController.do");
            rd.forward(request, response);
        } else {
            dao.delete(id);

            response.sendRedirect("CustomersListController.do");
        }

    }

}
