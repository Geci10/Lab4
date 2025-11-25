package com.example.parkinglot.servlets;

import com.example.parkinglot.ejb.UsersBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name="Users", value="/Users")
public class Users extends HttpServlet {

    @Inject
    UsersBean usersBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("users", usersBean.findAllUsers());
        request.setAttribute("activePage", "Users");

        request.getRequestDispatcher("/WEB-INF/pages/users.jsp").forward(request, response);
    }
}
