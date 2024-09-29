package com.example.controllers;


import com.example.entities.Categary;
import com.example.services.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {

        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<Page<Categary>> getAllCategory(@RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "10") int size) {
        PageRequest pagable = PageRequest.of(page, size);
        return ResponseEntity.ok(categoryService.get(pagable));
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
    public ResponseEntity<String> deleteCategory(@PathVariable long id) {
        categoryService.delete(id);
        return ResponseEntity.ok("deleted successfully!");
    }

}
