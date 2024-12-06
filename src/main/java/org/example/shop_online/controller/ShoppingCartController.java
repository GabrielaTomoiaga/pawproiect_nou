package org.example.shop_online.controller;

import org.example.shop_online.model.Product;
import org.example.shop_online.repository.ProductRepository;
import org.example.shop_online.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShoppingCartController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/add-to-cart/{productId}")
    public String addToCart(@PathVariable Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            shoppingCartService.addProductToCart(product);
        } else {
            System.out.println("Produsul nu a fost găsit în baza de date.");
        }
        return "redirect:/cosul_meu"; // Redirecționează la pagina de coș
    }

    @GetMapping("/cosul_meu")
    public String getCart(Model model) {
        model.addAttribute("cart", shoppingCartService.getCart());
        return "cosul_meu";
    }
}