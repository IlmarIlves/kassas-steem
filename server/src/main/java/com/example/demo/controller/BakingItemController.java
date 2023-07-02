package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BakingItem;
import com.example.demo.service.BakingItemService;

@RestController
@RequestMapping("/baking-items")
public class BakingItemController {
    private final BakingItemService bakingItemService;

    public BakingItemController(BakingItemService bakingItemService) {
        this.bakingItemService = bakingItemService;
    }

    @GetMapping
    public List<BakingItem> getAllBakingItems() {
        return bakingItemService.getAllBakingItems();
    }

    @PostMapping
    public BakingItem createBakingItem(@RequestBody BakingItem bakingItem) {
        return bakingItemService.createBakingItem(bakingItem);
    }

    @GetMapping("/{id}")
    public BakingItem getBakingItemById(@PathVariable Integer id) {
        return bakingItemService.getBakingItemById(id);
    }

    // Other endpoints for updating, deleting, etc.
}
