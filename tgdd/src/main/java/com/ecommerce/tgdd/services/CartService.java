package com.ecommerce.tgdd.services;

import com.ecommerce.tgdd.domain.Product;

import java.util.List;

public interface CartService {
    void addProduct(long userId, long productId);

    List<Product> listProductInCart(long userId);
}
