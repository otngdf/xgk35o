package org.zgdf.ea.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.zgdf.ea.db.CustomersDao;

public class CustomersCreateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cname = request.getParameter("cname");
        int czip = Integer.parseInt(request.getParameter("czip"));
        String ccity = request.getParameter("ccity");
        String caddress = request.getParameter("caddress");

        CustomersDao dao = new CustomersDao();

        dao.insert(cname, czip, ccity, caddress);

        response.sendRedirect("CustomersListController");

    }

}
