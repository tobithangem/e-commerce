package com.ecommerce.tgdd.controllers;

import com.ecommerce.tgdd.dto.sdi.ProductSdi;
import com.ecommerce.tgdd.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;

    @ResponseBody
    @PostMapping(path = "save", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> save(@RequestParam(value = "image") MultipartFile image,
                                  @RequestParam(value = "id") Long id,
                                  @RequestParam(value = "categoryId") Long categoryId,
                                  @RequestParam(value = "shortName") String shortName,
                                  @RequestParam(value = "description") String description,
                                  @RequestParam(value = "price") Long price,
                                  @RequestParam(value = "quantity") Integer quantity) throws Exception {

        ProductSdi request = ProductSdi.builder()
                .id(id)
                .categoryId(categoryId)
                .description(description)
                .image(image)
                .price(price)
                .quantity(quantity)
                .shortName(shortName)
                .build();
        productService.save(request);

        return ResponseEntity.ok("thanh cong");
    }
}
