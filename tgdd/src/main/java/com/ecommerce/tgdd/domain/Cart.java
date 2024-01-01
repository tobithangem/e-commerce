package com.ecommerce.tgdd.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity(name = "CART")
public class Cart {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CODE")
    private Long userId;

    @Column(name = "NAME")
    private Long productId;

    @Column(name = "STATUS")
    private Integer status;
}
