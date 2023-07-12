package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
    List<Ingredient> findAllByOrderByQuantityDesc();

    List<Ingredient> findAllByOrderByQuantityAsc();
}
