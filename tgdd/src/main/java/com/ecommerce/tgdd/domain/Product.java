package com.ecommerce.tgdd.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CATEGORY_ID")
    private Long categoryId;

    @Column(name = "SHORT_NAME")
    private String shortName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private Long price;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @Column(name = "STATUS")
    private Integer status;
}
