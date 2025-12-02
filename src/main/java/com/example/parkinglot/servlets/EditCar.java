package com.example.parkinglot.servlets;

import com.example.parkinglot.common.CarDto;
import com.example.parkinglot.ejb.CarsBean;
import com.example.parkinglot.ejb.UsersBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "EditCar", value = "/EditCar")
public class EditCar extends HttpServlet {

    @Inject
    private UsersBean usersBean;

    @Inject
    private CarsBean carsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Get all users for the dropdown
        request.setAttribute("users", usersBean.findAllUsers());

        // 2. Get the car id from query parameter ?id=...
        Long carId = Long.parseLong(request.getParameter("id"));

        // 3. Load the car DTO
        CarDto car = carsBean.findById(carId);
        request.setAttribute("car", car);

        // 4. Active menu & forward to JSP
        request.setAttribute("activePage", "Cars");
        request.getRequestDispatcher("/WEB-INF/pages/editCar.jsp")
                .forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Read updated values from form
        Long carId = Long.parseLong(request.getParameter("car_id"));
        String licensePlate = request.getParameter("license_plate");
        String parkingSpot = request.getParameter("parking_spot");
        Long ownerId = Long.parseLong(request.getParameter("owner_id"));

        // Call business logic (update method in CarsBean)
        carsBean.updateCar(carId, licensePlate, parkingSpot, ownerId);

        // Redirect back to Cars page
        response.sendRedirect(request.getContextPath() + "/Cars");
    }

}
