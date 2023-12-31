package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Ingredient;
import com.example.demo.service.IngredientService;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Ingredient> getAllIngredients() {
        // This returns a JSON or XML with the Registrys
        return ingredientService.getAll();
    }

    // Endpoint to get ingredients ordered by quantity in descending order
    @GetMapping("/order/desc")
    public List<Ingredient> getIngredientsOrderByQuantityDesc() {
        return ingredientService.getIngredientsOrderByQuantityDesc();
    }

    // Endpoint to get ingredients ordered by quantity in ascending order
    @GetMapping("/order/asc")
    public List<Ingredient> getIngredientsOrderByQuantityAsc() {
        return ingredientService.getIngredientsOrderByQuantityAsc();
    }

}