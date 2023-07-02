package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.BakingItem;

// This will be AUTO IMPLEMENTED by Spring into a Bean called RegistryRepository
// CRUD refers Create, Read, Update, Delete

public interface BakingItemRepository extends CrudRepository<BakingItem, Integer> {
    // List<BakingItem> findAll();

}
