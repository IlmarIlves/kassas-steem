package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping("/add")
    public String addNewBakingItem(@RequestParam String name) {
        BakingItem bakingItem = new BakingItem();
        bakingItem.setName(name);

        // Create Ingredients and associate them with the BakingItem
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("Ingredient 1");
        ingredient1.setBakingItem(bakingItem);
        bakingItem.getIngredients().add(ingredient1);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("Ingredient 2");
        ingredient2.setBakingItem(bakingItem);
        bakingItem.getIngredients().add(ingredient2);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setName("Ingredient 3");
        ingredient3.setBakingItem(bakingItem);
        bakingItem.getIngredients().add(ingredient3);

        // Save the BakingItem
        bakingItemService.saveBakingItem(bakingItem);

        return "Saved";
    }
}