package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Registry;

// This will be AUTO IMPLEMENTED by Spring into a Bean called RegistryRepository
// CRUD refers Create, Read, Update, Delete

public interface RegistryRepository extends CrudRepository<Registry, Integer> {

}