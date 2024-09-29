package com.example.services;

import com.example.entities.Product;
import com.example.repositories.ProductRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {

    final
    ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Page<Product> get(Pageable pageable) {
        return productRepo.findAll(pageable);
    }

    @Override
    public Product get(long id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product update(long id, Product product) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if(optionalProduct.isEmpty()) return null;
        Product newProduct = optionalProduct.get().update(product);
        return productRepo.saveAndFlush(newProduct);
    }

    @Override
    public void delete(long id) {
        productRepo.deleteById(id);
    }
}
