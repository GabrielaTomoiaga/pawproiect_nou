
package org.example.shop_online.controller;

import org.example.shop_online.model.Product;
import org.example.shop_online.repository.ProductRepository;
import org.example.shop_online.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/cosul_meu")
    public String viewCart(Model model) {
        model.addAttribute("cart", shoppingCartService.getCart());
        return "cosul_meu";
    }

    @GetMapping("/add-to-cart/{productId}")
    public String addProductToCart(@PathVariable Long productId, Model model) {

        Product product = productRepository.findById(productId).orElse(null);

        if (product != null) {

            shoppingCartService.addProductToCart(product);
        }

        return "redirect:/cosul_meu";
    }
}


/*
package org.example.shop_online.controller;
import org.example.shop_online.model.Product;
import org.example.shop_online.service.ProductService;
import org.example.shop_online.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShoppingCartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    // Adăugarea unui produs în coș
    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam Long productId, @RequestParam int quantity, Model model) {
        // Căutăm produsul în baza de date folosind ProductService
        Product product = productService.getProductById(productId)
                .orElseThrow(() -> new RuntimeException("Produsul nu a fost găsit"));

        // Adăugăm produsul în coșul de cumpărături
        shoppingCartService.addProductToCart(product, quantity);


        model.addAttribute("message", "Produsul a fost adăugat în coș cu succes!");
        return "redirect:/cosul_meu";  // Redirecționează către pagina cu coșul
    }
}

 */