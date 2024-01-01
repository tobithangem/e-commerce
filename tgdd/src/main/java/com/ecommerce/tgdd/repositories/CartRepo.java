package com.ecommerce.tgdd.repositories;

import com.ecommerce.tgdd.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {
    List<Cart> findByUserId(Long userId);
}
