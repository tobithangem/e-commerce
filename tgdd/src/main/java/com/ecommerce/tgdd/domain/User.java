package com.ecommerce.tgdd.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "USERNAME")
    private String userName;
    @Column(name = "PASSWORD_HASH")
    private String passwordHash;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
}
