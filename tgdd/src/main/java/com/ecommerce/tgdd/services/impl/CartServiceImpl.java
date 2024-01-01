package com.ecommerce.tgdd.services.impl;

import com.ecommerce.tgdd.domain.Cart;
import com.ecommerce.tgdd.domain.Product;
import com.ecommerce.tgdd.repositories.CartRepo;
import com.ecommerce.tgdd.repositories.ProductRepo;
import com.ecommerce.tgdd.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepo cartRepo;
    @Autowired
    ProductRepo productRepo;
    @Override
    public void addProduct(long userId, long productId) {
        Cart cart = Cart.builder()
                .userId(userId)
                .productId(productId)
                .status(1)
                .build();
        cartRepo.save(cart);
    }

    @Override
    public List<Product> listProductInCart(long userId) {
        List<Cart> carts = cartRepo.findByUserId(userId);
        List<Product> products = new ArrayList<>();
        if (carts.isEmpty()) return null;

        for (Cart cart : carts) {
            productRepo.findById(cart.getProductId()).ifPresent(products::add);
        }

        return products;
    }
}
