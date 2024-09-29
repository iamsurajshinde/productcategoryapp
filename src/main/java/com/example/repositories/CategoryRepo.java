package com.example.repositories;

import com.example.entities.Categary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Categary, Long> {
}
