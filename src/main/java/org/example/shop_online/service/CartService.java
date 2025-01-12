package org.example.shop_online.service;
import org.example.shop_online.model.CartItem;
import org.example.shop_online.model.Product;
import org.example.shop_online.model.User;
import org.example.shop_online.repository.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartItemRepository cartItemRepository;

    public CartService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public void saveCartItem(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }

    public List<CartItem> getCartItemsByUser(User user) {
        return cartItemRepository.findByUser(user);
    }

    public CartItem findCartItemByProductAndUser(Product product, User user) {
        return cartItemRepository.findByProductAndUser(product, user);
    }
}