/*
package org.example.shop_online.service;
import org.example.shop_online.model.CartItem;
import org.example.shop_online.model.Product;
import org.example.shop_online.model.User;
import org.example.shop_online.repository.CartItemRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShoppingCartService {

    private final CartItemRepository cartItemRepository;

    public ShoppingCartService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    // Adăugarea unui produs în coșul de cumpărături
    public void addProductToCart(Product product, int quantity) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        CartItem cartItem = new CartItem(product, currentUser, quantity);

        cartItemRepository.save(cartItem);  // Salvăm CartItem în baza de date
    }

    // Obținerea articolelor din coș pentru un utilizator
    public List<CartItem> getCartItemsForUser(User user) {
        return cartItemRepository.findByUserId(user.getId());
    }
}
*/
package org.example.shop_online.service;
import org.example.shop_online.model.Product;
import org.example.shop_online.model.ShoppingCart;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;

@Service
public class ShoppingCartService {

    private final HttpSession session;

    public ShoppingCartService(HttpSession session) {
        this.session = session;
    }

    public void addProductToCart(Product product) {
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart == null) {
            cart = new ShoppingCart();
            session.setAttribute("cart", cart);
        }
        cart.addProduct(product);
    }

    public ShoppingCart getCart() {
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart == null) {
            cart = new ShoppingCart();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    public void removeProductFromCart(Product product) {
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart != null) {
            cart.removeProduct(product);
        }
    }
}

