package com.ecommerce.tgdd.services;

import com.ecommerce.tgdd.dto.sdi.ProductSdi;
import javassist.NotFoundException;

public interface ProductService {
    void save(ProductSdi request) throws Exception;
}
