package org.zgdf.ea.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.zgdf.ea.db.CustomersDao;
import java.util.List;
import org.zgdf.ea.model.Customers;

public class CustomersListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CustomersDao dao = new CustomersDao();
        
        List<Customers> listCustomers = dao.list();
        
        HttpSession session = request.getSession();
        
        request.setAttribute("listCustomers", listCustomers);
        
        if("admin".equals((String)session.getAttribute("role"))){
            request.getRequestDispatcher("customers.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("start.jsp").forward(request, response);
        }
 
        
//            session.setAttribute("listCustomers", listCustomers);
//            response.sendRedirect("start.jsp");

    }

}
