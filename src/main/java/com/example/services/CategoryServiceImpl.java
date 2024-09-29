package com.example.services;

import com.example.entities.Categary;
import com.example.repositories.CategoryRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Page<Categary> get(Pageable pageable) {
        return categoryRepo.findAll(pageable);
    }

    @Override
    public Categary get(long id) {
        return categoryRepo.findById(id).orElse(null);
    }

    @Override
    public Categary save(Categary categary) {
        return categoryRepo.save(categary);
    }

    @Override
    public Categary update(long id, Categary categary) {
        return categoryRepo.saveAndFlush(categary);
    }

    @Override
    public void delete(long id) {
        categoryRepo.deleteById(id);
    }
}
