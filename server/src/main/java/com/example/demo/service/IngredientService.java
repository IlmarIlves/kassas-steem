package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Ingredient;
import com.example.demo.repository.IngredientRepository;

@Service
public class IngredientService {
    @Autowired
    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public @ResponseBody Iterable<Ingredient> getAll() {
        // This returns a JSON or XML with the Registrys
        return ingredientRepository.findAll();
    }

    public List<Ingredient> getIngredientsOrderByQuantityDesc() {
        return ingredientRepository.findAllByOrderByQuantityDesc();
    }

    public List<Ingredient> getIngredientsOrderByQuantityAsc() {
        return ingredientRepository.findAllByOrderByQuantityAsc();
    }

}
