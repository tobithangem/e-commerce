package com.ecommerce.tgdd.services.impl;

import com.ecommerce.tgdd.domain.Category;
import com.ecommerce.tgdd.domain.Product;
import com.ecommerce.tgdd.dto.sdi.ProductSdi;
import com.ecommerce.tgdd.repositories.CategoryRepo;
import com.ecommerce.tgdd.repositories.ProductRepo;
import com.ecommerce.tgdd.services.ProductService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    CategoryRepo categoryRepo;

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/static/uploads";

    @Override
    public void save(ProductSdi request) throws Exception {
        //check category id
        Category category = categoryRepo.findById(request.getCategoryId()).orElse(null);
        if (category == null) throw new NotFoundException("Luu san pham that bai. Khong tim thay categoty co Id tuong ung: " + request.getCategoryId());

        //save image
        String newFileName = uniqueString();
        StringBuilder imageFileName = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, newFileName);
        imageFileName.append(request.getImage().getOriginalFilename());
        try {
            Files.write(fileNameAndPath, request.getImage().getBytes());
        } catch (IOException ioe) {
            throw new IOException("Luu san pham that bai. Khong the luu file image");
        }

        //save product
        Product product = Product.builder()
                .id(request.getId())
                .categoryId(request.getCategoryId())
                .shortName(request.getShortName())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .description(request.getDescription())
                .imageUrl("uploads/" + newFileName)
                .status(1)
                .build();

        productRepo.save(product);
    }

    private static String uniqueString() {
        String random = UUID.randomUUID().toString();
        random = random.replaceAll("-", "");
        random = random.substring(0, 16);

        return random;
    }
}
