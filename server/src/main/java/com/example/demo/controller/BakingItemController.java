package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BakingItem;
import com.example.demo.entity.Ingredient;
import com.example.demo.service.BakingItemService;

@RestController
@RequestMapping("/api/baking-items")
public class BakingItemController {
    private final BakingItemService bakingItemService;

    public BakingItemController(BakingItemService bakingItemService) {
        this.bakingItemService = bakingItemService;
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addNewBakingItem(@RequestParam String name,
            @RequestParam List<Ingredient> ingredients) {
        BakingItem bakingItem = new BakingItem();
        bakingItem.setName(name);

        // Create Ingredients and associate them with the BakingItem
        List<Ingredient> ingredientList = new ArrayList<>();
        for (Ingredient ingredientProp : ingredients) {
            Ingredient ingredient = new Ingredient();
            ingredient.setName(ingredientProp.getName());
            ingredient.setQuantity(ingredientProp.getQuantity());
            ingredient.setBakingItem(bakingItem);
            ingredientList.add(ingredient);
        }

        // Set the Ingredients on the BakingItem
        bakingItem.setIngredients(ingredientList);

        // Save the BakingItem
        bakingItemService.saveBakingItem(bakingItem);

        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<BakingItem> getAllBakingItems() {
        // This returns a JSON or XML with the Registrys
        return bakingItemService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BakingItem> getBakingItemById(@PathVariable Long id) {
        BakingItem bakingItem = bakingItemService.getBakingItemById(id);
        if (bakingItem != null) {
            return ResponseEntity.ok(bakingItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}