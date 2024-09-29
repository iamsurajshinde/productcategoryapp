package com.example.services;

import com.example.entities.Categary;

import java.util.List;

public interface CategoryService {
    List<Categary> get();
    Categary get(long id);
    Categary save(Categary categary);
    Categary update(long id, Categary categary);
    Categary delete(long id);


}
