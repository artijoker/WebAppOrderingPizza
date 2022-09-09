package com.example.webapporderingpizza.data.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "url_image", nullable = false)
    private String urlImage;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "sauce_id", referencedColumnName = "id")
    private Sauce sauce;

    @ManyToOne
    @JoinColumn(name = "dough_id", referencedColumnName = "id")
    private Dough dough;

//    @ManyToOne
//    @JoinColumn(name = "stuffing_id", referencedColumnName = "id")
//    private Stuffing stuffing;

    @OneToMany(mappedBy = "pizza", fetch = FetchType.EAGER)
    private List<Topping> toppings;

    @OneToMany(mappedBy = "pizza")
    private List<Order> orders;

    public double getPrice(){
        var result = dough.getPrice() + sauce.getPrice();
        for (var topping: toppings) {
            result += topping.getIngredient().getPrice() * topping.getQuantity();
        }
        return result;
    }

    public String getInfo(){
        StringBuilder builder = new StringBuilder();
        builder.append(dough.getName());
        builder.append(", ");
        builder.append(sauce.getName());
        for (var topping: toppings) {
            builder.append(", ");
            builder.append(topping.getIngredient().getName());
        }
        return builder.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
