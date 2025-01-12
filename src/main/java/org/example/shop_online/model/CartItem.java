package org.example.shop_online.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int quantity;
    private double totalPrice;

    // Constructori
    public CartItem() {
    }

    public CartItem(Product product, int quantity, User user) {
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = product.getPrice() * quantity;
        this.user = user;
    }

    // Getters și Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        this.totalPrice = product.getPrice() * this.quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.totalPrice = product.getPrice() * quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

