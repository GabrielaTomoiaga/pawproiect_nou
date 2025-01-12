package org.example.shop_online.repository;
import org.example.shop_online.model.CartItem;
import org.example.shop_online.model.Product;
import org.example.shop_online.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUser(User user);
    CartItem findByProductAndUser(Product product, User user);
}
