package com.example.services;

import com.example.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<Category> get(Pageable pageable);

    Category get(long id);

    Category save(Category category);

    Category update(long id, Category category);

    void delete(long id);


}
