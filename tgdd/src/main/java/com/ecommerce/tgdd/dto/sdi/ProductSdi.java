package com.ecommerce.tgdd.dto.sdi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductSdi {
    private Long id;
    private Long categoryId;
    private String shortName;
    private String description;
    private Long price;
    private Integer quantity;
    private MultipartFile image;
}
