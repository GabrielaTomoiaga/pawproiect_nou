package org.example.shop_online.controller;
import org.example.shop_online.model.Product;
import org.example.shop_online.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    private final ProductRepository productRepository;

    public CartController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // metoda pentru adaugarea unui produs în cos
    @GetMapping("/addToCart")
    public String addToCart(@RequestParam("productId") Long productId, HttpSession session) {
        // cautam produsul in baza de date dupa ID-ul primit
        Product productToAdd = productRepository.findById(productId).orElse(null);

        if (productToAdd == null) {
            return "redirect:/cart";
        }

        // obtinem cosul din sesiune sau cream unul nou daca nu exista
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        // adaugam produsul în cosul de cumparaturi
        cart.add(productToAdd);
        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }

    // metoda pentru elimina produs din cos
    @GetMapping("/removeFromCart")
    public String removeFromCart(@RequestParam("productId") Long productId, HttpSession session) {
        List<Product> cart = (List<Product>) session.getAttribute("cart");

        if (cart != null) {
            cart.removeIf(product -> product.getId().equals(productId));
            session.setAttribute("cart", cart);
        }

        return "redirect:/cart";
    }
    // metoda pentru vizualizarea cosul
    @GetMapping("/cart")
    public String viewCart(Model model, HttpSession session) {
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        double total = cart.stream().mapToDouble(Product::getPrice).sum();

        model.addAttribute("cart", cart);
        model.addAttribute("total", total);

        return "cosul_meu";
    }
}