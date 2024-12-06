package org.example.shop_online.controller;

import org.example.shop_online.model.Product;
import org.example.shop_online.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BijuteriiController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/bijuterii/{categorie}")
    public String getBijuteriiByCategorie(@PathVariable String categorie, Model model) {
        // Obține produsele din baza de date pentru categoria specificată
        List<Product> produse = productRepository.findByCategory(categorie);

        if (produse.isEmpty()) {
            model.addAttribute("error", "Nu sunt produse în această categorie!");
        }

        model.addAttribute("produse", produse);
        model.addAttribute("categorie", categorie);
        return "category";
    }
}

