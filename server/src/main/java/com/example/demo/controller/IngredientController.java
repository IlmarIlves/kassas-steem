package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Ingredient;
import com.example.demo.service.IngredientService;

public class IngredientController {
    // private final IngredientService ingredientService;

    // public IngredientController(IngredientService ingredientService) {
    // this.ingredientService = ingredientService;
    // }

    // @GetMapping
    // public List<Ingredient> getAllIngredients() {
    // return ingredientService.getAllIngredients();
    // }

    // @PostMapping
    // public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
    // return ingredientService.createIngredient(ingredient);
    // }

    // @GetMapping("/{id}")
    // public Ingredient getIngredientById(@PathVariable Integer id) {
    // return ingredientService.getIngredientById(id);
    // }

    // Other endpoints for updating, deleting, etc.
}
