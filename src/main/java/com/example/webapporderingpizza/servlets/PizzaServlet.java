package com.example.webapporderingpizza.servlets;

import java.io.*;

import com.example.webapporderingpizza.data.PizzaDb;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "pizzaServlet", value = "/all-pizza")
public class PizzaServlet extends HttpServlet {
    private final PizzaDb _db;

    @Inject
    public PizzaServlet(PizzaDb db) {
        _db = db;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        var pizzas = _db.getAllPizzas();

        request.setAttribute("pizzas", pizzas);
        getServletContext().getRequestDispatcher("/all-pizza.jsp").forward(request, response);
    }

    public void destroy() {
    }
}