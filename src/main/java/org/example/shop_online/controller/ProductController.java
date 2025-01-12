package org.example.shop_online.controller;
import org.example.shop_online.model.Product;
import org.example.shop_online.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // obtine toate produsele
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // obtine produsele dintr-o categorie
    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }

    // obtine un produs după ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // creeaza un produs nou
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    // actualizeaza un produs existent
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        try {
            return ResponseEntity.ok(productService.updateProduct(id, updatedProduct));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // sterge un produs dupa ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}