package com.example.parkinglot.servlets;

import com.example.parkinglot.ejb.CarsBean;
import com.example.parkinglot.ejb.UsersBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AddCar", value = "/AddCar")
public class AddCar extends HttpServlet {

    @Inject
    private CarsBean carsBean;

    @Inject
    private UsersBean usersBean;

    // Show the form
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get all users for the dropdown
        request.setAttribute("users", usersBean.findAllUsers());
        request.setAttribute("activePage", "Cars");

        request.getRequestDispatcher("/WEB-INF/pages/addCar.jsp")
                .forward(request, response);
    }

    // Process form submission
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String licensePlate = request.getParameter("license_plate");
        String parkingSpot = request.getParameter("parking_spot");

        Long userId = Long.parseLong(request.getParameter("owner_id"));

        carsBean.createCar(licensePlate, parkingSpot, userId);

        response.sendRedirect(request.getContextPath() + "/Cars");
    }
}
