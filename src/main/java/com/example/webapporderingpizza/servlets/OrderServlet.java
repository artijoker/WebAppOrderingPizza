package com.example.webapporderingpizza.servlets;

import com.example.webapporderingpizza.ServiceEmail;
import com.example.webapporderingpizza.data.PizzaDb;
import com.example.webapporderingpizza.data.entities.Client;
import com.example.webapporderingpizza.data.entities.Order;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;

@WebServlet(name = "OrderServlet", value = "/order")
public class OrderServlet extends HttpServlet {

    private final PizzaDb _db;

    @Inject
    public OrderServlet(PizzaDb db) {
        _db = db;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var name = request.getParameter("name");
        var email = request.getParameter("email");
        var phone = request.getParameter("phone");
        var address = request.getParameter("address");
        var pizzaId = request.getParameter("pizzaId");

        var pizza = _db.getPizzaById(Long.parseLong(pizzaId));

        var client = new Client(name, email, phone);
        _db.addNewClient(client);

        var order = new Order(address, client, pizza);
        _db.addOrder(order);
        var message = "Пицца: " + pizza.getName() + "\n" + pizza.getInfo() + "\nЦена: "
                + pizza.getPrice() + "\nАдресс доставки: " + address;
        try {
            ServiceEmail.sendEmail("artijoker@gmail.com", "Заказ", message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


        getServletContext().getRequestDispatcher("/success.jsp").forward(request, response);
    }
}
