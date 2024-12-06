package org.example.shop_online.model;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> products = new ArrayList<>();  // Lista de produse din coș

    public void addProduct(Product product) {
        products.add(product);  // Adaugă produsul în coș
    }

    public List<Product> getProducts() {
        return products;  // Returnează lista de produse
    }

    public void clear() {
        products.clear();  // Golește coșul
    }
}