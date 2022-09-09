package com.example.webapporderingpizza.servlets;

import com.example.webapporderingpizza.data.PizzaDb;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "PizzaDetailsServlet", value = "/pizza-details")
public class PizzaDetailsServlet extends HttpServlet {

    private final PizzaDb _db;

    @Inject
    public PizzaDetailsServlet(PizzaDb db) {
        _db = db;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var id = request.getParameter("id");
        var pizza = _db.getPizzaById(Long.parseLong(id));


        request.setAttribute("pizza", pizza);
        getServletContext().getRequestDispatcher("/pizza-details.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
