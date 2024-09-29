package com.example.services;

import com.example.entities.Category;
import com.example.repositories.CategoryRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Page<Category> get(Pageable pageable) {
        return categoryRepo.findAll(pageable);
    }

    @Override
    public Category get(long id) {
        return categoryRepo.findById(id).orElse(null);
    }

    @Override
    public Category save(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category update(long id, Category category) {
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        if(optionalCategory.isEmpty()) return null;
        Category newCategory = optionalCategory.get().update(category);
        return categoryRepo.saveAndFlush(newCategory);
    }

    @Override
    public void delete(long id) {
        categoryRepo.deleteById(id);
    }
}
