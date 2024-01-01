package com.ecommerce.tgdd.controllers;

import com.ecommerce.tgdd.domain.Category;
import com.ecommerce.tgdd.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody Category request) {
        categoryService.save(request);
        return ResponseEntity.ok("thanh cong");
    }
}
