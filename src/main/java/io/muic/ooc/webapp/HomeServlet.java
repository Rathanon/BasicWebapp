package io.muic.ooc.webapp;

import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date date = new Date();

        request.setAttribute("date", date);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/home.jsp");
        requestDispatcher.include(request, response);

    }
}
