package com.example.webapporderingpizza.data;
import com.example.webapporderingpizza.data.entities.*;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class PizzaDb implements Serializable {


    public List<Pizza> getAllPizzas(){
        var session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        var pizzas =  session.createQuery("from Pizza", Pizza.class).getResultList();
        session.getTransaction().commit();
        session.clear();
        return pizzas;
    }

    public Pizza getPizzaById(long pizzaId){
        var session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        var pizza =  session.createQuery("from Pizza where id=:id", Pizza.class)
                .setParameter("id", pizzaId)
                .getSingleResult();
        session.getTransaction().commit();
        session.clear();
        return pizza;
    }

    public void addOrder(Order order){
        var session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(order);
        session.getTransaction().commit();
        session.clear();
    }

    public void addNewClient(Client client){
        var session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(client);
        session.getTransaction().commit();
        session.clear();
    }
}
