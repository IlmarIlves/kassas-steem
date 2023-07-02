package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BakingItem;
import com.example.demo.entity.Ingredient;
import com.example.demo.entity.Registry;
import com.example.demo.repository.BakingItemRepository;
import com.example.demo.repository.IngredientRepository;
import com.example.demo.repository.RegistryRepository;

@RestController
@RequestMapping("/api")
public class MainController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private RegistryRepository registryRepository;

    private BakingItemRepository bakingItemRepository;

    private IngredientRepository ingredientRepository;

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody String addNewRegistry(@RequestParam String name, @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Registry n = new Registry();
        n.setName(name);
        n.setEmail(email);
        registryRepository.save(n);
        return "Saved";
    }

    @GetMapping(path = "/baking-items")
    public @ResponseBody Iterable<BakingItem> getAllBakingItems() {
        // This returns a JSON or XML with the Registrys
        return bakingItemRepository.findAll();
    }

    @GetMapping(path = "/ingredients")
    public @ResponseBody Iterable<Ingredient> getAllIngredients() {
        // This returns a JSON or XML with the Registrys
        return ingredientRepository.findAll();
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Registry> getAllRegistrys() {
        // This returns a JSON or XML with the Registrys
        return registryRepository.findAll();
    }
}