package com.ecommerce.tgdd.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "CATEGORY")
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;
}
