package com.example.controllers;


import com.example.entities.Categary;
import com.example.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Categary>> getAllCategory() {
        return ResponseEntity.ok(categoryService.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categary> getCategory(@PathVariable long id) {
        return ResponseEntity.ok(categoryService.get(id));
    }

    @PostMapping
    public ResponseEntity<Categary> saveCategory(@RequestBody Categary categary) {
        return ResponseEntity.ok(categoryService.save(categary));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categary> updateCategory(@PathVariable long id, @RequestBody Categary categary) {
        return ResponseEntity.ok(categoryService.update(id, categary));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Categary> deleteCategory(@PathVariable long id) {
        return ResponseEntity.ok(categoryService.delete(id));
    }

}
