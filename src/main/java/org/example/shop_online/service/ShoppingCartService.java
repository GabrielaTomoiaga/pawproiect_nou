package org.example.shop_online.service;
import org.example.shop_online.model.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartService {
    private List<Product> cart = new ArrayList<>();

    public void addProductToCart(Product product) {
        cart.add(product);
    }

    public List<Product> getCart() {
        return cart;
    }
}