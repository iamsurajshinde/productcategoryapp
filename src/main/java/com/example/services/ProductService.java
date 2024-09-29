package com.example.services;

import com.example.entities.Categary;
import com.example.entities.Product;

import java.util.List;

public interface ProductService {

    List<Product> get();
    Product get(long id);
    Product save(Product product);
    Product update(long id, Product product);
    Product delete(long id);

}
