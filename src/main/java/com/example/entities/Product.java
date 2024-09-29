package com.example.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name = "";
    private int qty = -1;
    private BigDecimal price = BigDecimal.ZERO;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category categoryId;

    public Product update(Product product) {
        if (!product.getName().isEmpty())
            this.name = product.getName();
        if (product.getQty() > -1)
            this.qty = product.getQty();
        if (product.getPrice().compareTo(BigDecimal.ZERO) > 0)
            this.price = product.getPrice();
        return this;
    }
}

