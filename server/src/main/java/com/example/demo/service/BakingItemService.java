package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.BakingItem;
import com.example.demo.repository.BakingItemRepository;

@Service
public class BakingItemService {
    @Autowired
    private final BakingItemRepository bakingItemRepository;

    public BakingItemService(BakingItemRepository bakingItemRepository) {
        this.bakingItemRepository = bakingItemRepository;
    }

    public BakingItem saveBakingItem(BakingItem bakingItem) {
        return bakingItemRepository.save(bakingItem);
    }

    public @ResponseBody Iterable<BakingItem> getAllBakingItems() {
        // This returns a JSON or XML with the Registrys
        return bakingItemRepository.findAll();
    }

}