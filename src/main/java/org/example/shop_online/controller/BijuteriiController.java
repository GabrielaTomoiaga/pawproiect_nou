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
    private ProductRepository productRepository; // injectarea repository-ului pentru acces la produse

    // ruta pentru afisarea produselor
    @GetMapping("/bijuterii/{categorie}")
    public String getBijuteriiByCategorie(@PathVariable String categorie, Model model) {
        // obtine produsele din baza de date pentru categoria specificata
        List<Product> produse = productRepository.findByCategory(categorie);

        // verifica daca exista produse în categoria respectiva
        if (produse.isEmpty()) {
            model.addAttribute("error", "Nu sunt produse în această categorie!");
        }

        // adauga produsele și categoria in model pentru afisare
        model.addAttribute("produse", produse);
        model.addAttribute("categorie", categorie);
        return "category";
    }
}

