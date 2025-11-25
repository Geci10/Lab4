package com.example.parkinglot.servlets;

import com.example.parkinglot.ejb.CarsBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Cars", value = "/Cars")
public class Cars extends HttpServlet {

    @Inject
    private CarsBean carsBean;   // <-- CORRECT

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Call EJB method
        List<?> cars = carsBean.findAllCars();

        request.setAttribute("cars", cars); // send cars list to JSP
        request.setAttribute("activePage", "Cars");

        request.getRequestDispatcher("/WEB-INF/pages/cars.jsp").forward(request, response);
    }
}
