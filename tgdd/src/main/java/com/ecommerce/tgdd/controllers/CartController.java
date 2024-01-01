package com.ecommerce.tgdd.controllers;

import com.ecommerce.tgdd.domain.Product;
import com.ecommerce.tgdd.dto.sdi.CartAddProductSdi;
import com.ecommerce.tgdd.services.CartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("cart")
public class CartController{
    @Autowired
    CartService cartService;

    @GetMapping("")
    public String productInCart(Model model, HttpSession session){
        Long userId = (Long) session.getAttribute("userId");

        List<Product> list = cartService.listProductInCart(userId);
        model.addAttribute("products", list);
        return "/client-side/user/cart";
    }

    @PostMapping("add-product/{productId}")
    public String addProduct(Model model, HttpSession session, @PathVariable long productId){
        Long userId = (Long) session.getAttribute("userId");

        cartService.addProduct(userId, productId);
        return "redirect:/cart";
    }
}
