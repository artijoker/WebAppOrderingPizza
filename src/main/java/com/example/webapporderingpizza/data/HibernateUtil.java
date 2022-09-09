package com.example.webapporderingpizza.data;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.example.webapporderingpizza.data.entities.*;
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {

            Configuration configuration = new Configuration()
                    .addAnnotatedClass(Dough.class)
                    .addAnnotatedClass(Sauce.class)
                    .addAnnotatedClass(Ingredient.class)
                    .addAnnotatedClass(Topping.class)
                    .addAnnotatedClass(Pizza.class)
                    .addAnnotatedClass(Client.class)
                    .addAnnotatedClass(Order.class);
            sessionFactory = configuration.buildSessionFactory();
        }

        return sessionFactory;
    }


}
