package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.BakingItem;
import com.example.demo.repository.BakingItemRepository;

@Service
public class BakingItemService {
    private final BakingItemRepository bakingItemRepository;

    public BakingItemService(BakingItemRepository bakingItemRepository) {
        this.bakingItemRepository = bakingItemRepository;
    }

    public BakingItem saveBakingItem(BakingItem bakingItem) {
        return bakingItemRepository.save(bakingItem);
    }
}