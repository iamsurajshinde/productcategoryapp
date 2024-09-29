package com.example.services;

import com.example.entities.Categary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<Categary> get(Pageable pageable);

    Categary get(long id);

    Categary save(Categary categary);

    Categary update(long id, Categary categary);

    void delete(long id);


}
