package com.ecommerce.tgdd.services.impl;

import com.ecommerce.tgdd.domain.Category;
import com.ecommerce.tgdd.repositories.CategoryRepo;
import com.ecommerce.tgdd.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public void save(Category request) {
        categoryRepo.save(request);
    }
}
