package com.example.services;

import com.example.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductService {

    Page<Product> get(Pageable pageable);

    Product get(long id);

    Product save(Product product);

    Product update(long id, Product product);

    void delete(long id);

}
